package com.avater.mymusicapplication;

import android.os.Handler;
import android.text.TextUtils;


/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：
 */

public enum NotificationManagerNew {
    INSTANCE;
    public static final String TAG = NotificationManagerNew.class.getSimpleName();

    public NotificationRecord removeNotifications;
    Runnable removeMsgCountRunnable = new Runnable() {
        @Override
        public void run() {
            if (removeNotifications != null) {
                Logger.i(TAG, "社交清零...");
                removeNotifications.notificationCount = 0;
            }
        }
    };

    // 移除消息
    public void removeNotification(Handler myHandler, String packageName) {
        NotificationRecord notificationRecord = PackageMap.getNotificationRecord(packageName, true);
        if (notificationRecord != null && (Math.abs(System.currentTimeMillis() - notificationRecord.removeTime) > 500)) {
            switch (notificationRecord.notificationType) {
                case PackageMap.TYPE_EMAIL:
                case PackageMap.TYPE_CALENDAR:
                case PackageMap.TYPE_OUTLOOK:
                case PackageMap.TYPE_GMAIL:
                case PackageMap.TYPE_SKYPE:
                    OutlookEx.clearCRC();
                    GMail.clearCRC();
                    Skype.clearCRC();
                case PackageMap.TYPE_SOCIAL:
                case PackageMap.TYPE_WECHAT:
                case PackageMap.TYPE_VIBER:
                case PackageMap.TYPE_SNAPCHAT:
                case PackageMap.TYPE_WHATSAPP:
                case PackageMap.TYPE_FACEBOOK:
                case PackageMap.TYPE_HANGOUTS:
                case PackageMap.TYPE_MESSENGER:
                case PackageMap.TYPE_INSTAGRAM:
                case PackageMap.TYPE_TWITTER:
                case PackageMap.TYPE_LINKEDIN:
                case PackageMap.TYPE_UBER:
                case PackageMap.TYPE_LINE:
                case PackageMap.TYPE_BOOKING:
                case PackageMap.TYPE_AIRBNB:
                case PackageMap.TYPE_FLIPBOARD:
                case PackageMap.TYPE_TELEGRAM:
                case PackageMap.TYPE_PANDORA:
                case PackageMap.TYPE_SPOTIFY:
                case PackageMap.TYPE_DROPBOX:
                case PackageMap.TYPE_SHAZAM:
                case PackageMap.TYPE_LIFT:
                case PackageMap.TYPE_WAZE:
                case PackageMap.TYPE_SLACK:
                case PackageMap.TYPE_DELIVEROO:
                case PackageMap.TYPE_PINTEREST:
                case PackageMap.TYPE_NETFLIX:
                case PackageMap.TYPE_YOUTUBE:
                case PackageMap.TYPE_GOOGLEMAP:
                case PackageMap.TYPE_PAYPAL:
                case PackageMap.TYPE_AIRFRANCE:
                case PackageMap.TYPE_BFMTV:
                case PackageMap.TYPE_BUSINESSINSIDER:
                case PackageMap.TYPE_CNN:
                case PackageMap.TYPE_LEMONDE:
                case PackageMap.TYPE_LE_FIGARO:
                case PackageMap.TYPE_MORANDINI_BLOG:
                case PackageMap.TYPE_INDIEGOGO:
                case PackageMap.TYPE_KICKSTARTER:
                case PackageMap.TYPE_STRIPE_DASHBOARD:
                case PackageMap.TYPE_KLM:
                case PackageMap.TYPE_EASY_JET:
                case PackageMap.TYPE_SWISS:
                case PackageMap.TYPE_LUFTHANSA:
                case PackageMap.TYPE_AMERICAN_AIRLINES:
                case PackageMap.TYPE_FLY_DELTA:
                case PackageMap.TYPE_JET_SMARTER:
                case PackageMap.TYPE_DIDI:
                case PackageMap.TYPE_UBER_EATS:
                case PackageMap.TYPE_MENTION:
                case PackageMap.TYPE_SWISS_QUOTE:
                case PackageMap.TYPE_DIAGRAL_CONNECT:
                case PackageMap.TYPE_NEST:
                case PackageMap.TYPE_NETATMO_SECURITY:
                case PackageMap.TYPE_UBS_FINANCIAL:
                case PackageMap.TYPE_N26_MOBILE_BANK:
                case PackageMap.TYPE_KAKAO_TALK:
                case PackageMap.TYPE_OPEN_TABLE:
                case PackageMap.TYPE_OTHER:
                    notificationRecord.notificationCount = 0;
                    break;
                case PackageMap.TYPE_QQ:
                    removeNotifications = notificationRecord;
                    myHandler.postDelayed(removeMsgCountRunnable, 1000);                             // 延迟1秒钟执行，若1秒钟内有新消息过来，则取消执行(解决QQ有新消息过来会先移除消息)
                    break;
            }
            notificationRecord.removeTime = System.currentTimeMillis();
        }
    }

    // 解析消息并发送
    public void parseNotification(Handler myHandler, Notifications notifications, boolean isOngoing) {
        myHandler.removeCallbacks(removeMsgCountRunnable);
        if (AppInfoUtil.INSTANCE.checkPackageNameType(notifications.packageName) != AppInfoUtil.FLAG_USER_APP) // 该通知是系统通知，不推送
            return;
//        int shockRingType = SPUtil.INSTANCE.getAppShockRingType(notifications.packageName);         // 获取该包名对应的震动类型
        int shockRingType = 1;         // 获取该包名对应的震动类型
//        shockRingType = 1;
        if (shockRingType <= 0 || TextUtils.isEmpty(notifications.content)) {                       // 开关关闭或者是系统应用推送
            Logger.e(TAG, "社交开关关闭了 或 通知内容为空");
            return;
        }

        NotificationRecord notificationRecord = PackageMap.getNotificationRecord(notifications.packageName, true);
        if (notificationRecord == null) return;

        if ((Math.abs(System.currentTimeMillis() - notificationRecord.addTime) > 100)) {
            boolean result = true;
            notificationRecord.addTime = System.currentTimeMillis();
            Logger.i(TAG, "notificationRecord.note:" + notificationRecord.note);
            if (!TextUtils.isEmpty(notificationRecord.note))                                        // 说明该app需要过滤
                result = NotificationUtil.INSTANCE.filterMessages(notificationRecord, notifications);
            Logger.d(TAG, "isOngoing = " + isOngoing + " , result = " + result);
            if (isOngoing || !result) return;
            Logger.e(TAG, "发送社交，社交内容>>" + notifications.toString() + ",\n shockType:" + shockRingType);
            notificationRecord.notificationCount++;
            boolean replySocial = NotificationUtil.INSTANCE.checkIsSupportReply(notificationRecord.note);
            String content = notifications.content.equals(notifications.title) && !TextUtils.isEmpty(notifications.text) ? notifications.text : notifications.content;
            MessagePush.INSTANCE.sendSocial(new NotificationInfo(notifications.title, content, notifications.timeStamp, notificationRecord.notificationType, notificationRecord.notificationCount, shockRingType, replySocial));
        } else {
            Logger.e(TAG, "本条通知不推送(和上一条的通知间隔少于100ms)");
        }
    }


}
