package com.avater.mymusicapplication;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;


import java.util.Date;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2017/3/17
 * 说明：消息推送，通过各种管理者整理好消息后，通过该类统一发送EventBus消息到PMessagePush
 */
public enum MessagePush {
    INSTANCE;



    private String TAG = MessagePush.class.getSimpleName();
    private Context context;
    private String mmsInageDesc = "";

    public MessagePush init(Context context) {
        this.context = context;
        LogUtil.init(new PushLogCall());
        initMessagePush();
        return this;
    }

    public void onDestroy() {
//        SMSManager.INSTANCE.end();
//        CalendarManager.INSTANCE.end();
    }


    private void startService(){
//        Intent service = new Intent(context, NotificationReceiveService.class);
//        context.startService(service);
    }


    private void initMessagePush() {
//        enableNotificationListenerService();
//        CallManager.INSTANCE.start();
//        SMSManager.INSTANCE.start();
//        CalendarManager.INSTANCE.start();
    }



    private void enableNotificationListenerService(){

//        try {
//            LogUtil.i(TAG, "------初始化消息...");
//            PackageManager pm = context.getPackageManager();
//            ComponentName componentName = new ComponentName(context, NotificationReceiveService.class);
//            pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
//            pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
//        } catch (NoClassDefFoundError e) {
//            LogUtil.i(TAG, "没找到该类的错误，先不管...!!!");
//        }

//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(!isNotificationListenerServiceRunning()){
//
//                }
//            }
//        },2000);
    }


    private boolean isNotificationListenerServiceRunning() {
//        ComponentName componentName = new ComponentName(context, NotificationReceiveService.class);
//        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningServiceInfo> runningServices = manager.getRunningServices(100);
//        if (runningServices == null || runningServices.size() <= 0) {
//            return false;
//        }
//        for (ActivityManager.RunningServiceInfo service : runningServices) {
//            if (componentName.equals(service.service)) {
//                if (service.pid == android.os.Process.myPid() ) {
//                    return true;
//                }
//            }
//        }
        return false;
    }



    public Context getContext() {
        return this.context;
    }

    public String getMMSImageDesc() {
        return mmsInageDesc;
    }

    public void sendSMS(CallSMSInfo callSMSInfo) {
        String nameOrNumber = TextUtils.isEmpty(callSMSInfo.name) ? callSMSInfo.phoneNo : callSMSInfo.name;
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_SMS, new Object[]{nameOrNumber, callSMSInfo.content, new Date(callSMSInfo.receiveTime), callSMSInfo.callSMSCount}));
    }

    public void sendIncomeCall(CallSMSInfo callSMSInfo) {
        String nameOrNumber = TextUtils.isEmpty(callSMSInfo.name) ? callSMSInfo.phoneNo : callSMSInfo.name;
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_INCOME_CALL, new Object[]{nameOrNumber}));
    }

    public void sendOffCall() {
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_OFF_CALL, null));
    }

    public void sendMissCall(CallSMSInfo callSMSInfo) {
        String nameOrNumber = TextUtils.isEmpty(callSMSInfo.name) ? callSMSInfo.phoneNo : callSMSInfo.name;
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_MISS_CALL, new Object[]{nameOrNumber, new Date(), callSMSInfo.callSMSCount}));
    }

    public void sendSocial(NotificationInfo notificationInfo) {
        LogUtil.i(TAG, "发送eventBus 消息");
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_SOCIAL, new Object[]{notificationInfo.title, notificationInfo.content, new Date(notificationInfo.timeStamp), notificationInfo.notificationType, notificationInfo.notificationCount, notificationInfo.shockRingType, notificationInfo.replySocial}));
    }

    public void sendEmail(NotificationInfo notificationInfo) {
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_EMAIL, new Object[]{notificationInfo.title, notificationInfo.content, new Date(notificationInfo.timeStamp), notificationInfo.notificationType, notificationInfo.notificationCount}));
    }

    public void sendCalendar(NotificationInfo notificationInfo) {
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_CALENDAR, new Object[]{notificationInfo.content, new Date(notificationInfo.timeStamp), notificationInfo.notificationCount}));
    }

    public void setCalendarView() {
//        EventBus.getDefault().post(new NotificationMessage(NotificationMessage.SEND_CALENDAR_VIEW, null));
    }


    private static class PushLogCall implements ILogPrintfCall {
        @Override
        public void iPrintf(String TAG, String msg) {
            Log.i(TAG, msg);
        }

        @Override
        public void wPrintf(String TAG, String msg) {
            Log.w(TAG, msg);
        }

        @Override
        public void ePrintf(String TAG, String msg) {
            Log.e(TAG, msg);
        }

        @Override
        public void vPrintf(String TAG, String msg) {
            Log.v(TAG, msg);
        }
    };

}
