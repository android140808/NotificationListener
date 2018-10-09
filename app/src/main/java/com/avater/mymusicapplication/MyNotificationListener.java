package com.avater.mymusicapplication;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Handler;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;

import org.greenrobot.eventbus.EventBus;


@SuppressLint("OverrideAbstract")
public class MyNotificationListener extends NotificationListenerService {

    private static final String TAG = "MyNotificationListener";
    private Handler myHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public synchronized void onNotificationPosted(StatusBarNotification sbn) {
        try {
            Logger.v(TAG, "新消息到来...");
            Notifications notifications = new Notifications();
            Notification notification = sbn.getNotification();
            if (notification == null) return;
            notifications.packageName = sbn.getPackageName();
            notifications.content = notification.tickerText != null ? notification.tickerText.toString() : "";
            notifications.timeStamp = sbn.getPostTime();
            notifications.title = getPackageManager().getApplicationLabel(getPackageManager().getPackageInfo(sbn.getPackageName(), 0).applicationInfo).toString();
            notifications.remoteViews = notification.bigContentView;
            notifications.isOngoing = sbn.isOngoing();
            if (android.os.Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                Object name = notification.extras.get(Notification.EXTRA_TITLE);
                Object text = notification.extras.get(Notification.EXTRA_TEXT);
                Object summaryText = notification.extras.get(Notification.EXTRA_SUMMARY_TEXT);

                Object lines = notification.extras.get(Notification.EXTRA_TEXT_LINES);
                if (lines != null) {
                    Logger.i(TAG, "history = " + lines.toString());
                    CharSequence[] mTexts = (CharSequence[]) lines;
                    Logger.i(TAG, "mTexts.length = " + mTexts.length);
                    Logger.i(TAG, "mTexts[length-1] = " + mTexts[mTexts.length - 1]);
                    notifications.line = mTexts[mTexts.length - 1] + "";
                }

                notifications.name = name != null ? (name.toString().trim().lastIndexOf(":") == name.toString().trim().length() - 1 ? name.toString().trim() + " " : name.toString().trim() + ": ") : "";
                notifications.text = text != null ? text.toString() : "";
                notifications.summaryText = summaryText != null ? summaryText.toString() : "";
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    Object object = notification.extras.get(Notification.EXTRA_BIG_TEXT);
                    if (object != null) {
                        notifications.bigText = object.toString();
                    }
                }
                try {
                    notifications.progress = notification.extras.getInt(Notification.EXTRA_PROGRESS, 0);
                    notifications.progressMax = notification.extras.getInt(Notification.EXTRA_PROGRESS_MAX, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            notifications.content = (TextUtils.isEmpty(notifications.content) && !TextUtils.isEmpty(notifications.text)) ? notifications.text : notifications.content;
            Logger.i(TAG, "消息:" + notifications.toString());
            if (MusicControl.INSTANCE.isContain(notifications.packageName)) {
                MusicMessage mm = new MusicMessage(notifications.packageName, notifications.title, notifications.content, notifications.timeStamp, notifications.name, notifications.text);
                MusicControl.INSTANCE.handleMusicData(mm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Logger.d(TAG, "消息被移除了");
        NotificationManagerNew.INSTANCE.removeNotification(myHandler, sbn.getPackageName());

    }
}
