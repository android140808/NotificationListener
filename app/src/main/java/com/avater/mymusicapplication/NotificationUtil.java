package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2018/3/29
 * 说明：通知工具类，主要辅助处理消息
 */

public enum NotificationUtil {
    INSTANCE;

    private String TAG = this.getClass().getSimpleName();

    public boolean filterMessages(NotificationRecord notificationRecord, Notifications notifications) {
        switch (notificationRecord.note) {

            case PackageMap.TYPE_NOTE_SOCIAL_WHATS_APP:
                Logger.i(TAG, "WhatsApp过滤");
                return WhatsApp.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_FACEBOOK:
                Logger.i(TAG, "Facebook过滤");
                return Facebook.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_FACEBOOK_MESSENGER:
                Logger.i(TAG, "Facebook Messenger过滤");
                return FacebookMessenger.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_SKYPE:
                Logger.i(TAG, "Skype过滤");
                return Skype.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_TWITTER:
                Logger.i(TAG, "Twitter过滤");
                return Twitter.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_LINE:
                Logger.i(TAG, "Line过滤");
                if (TextUtils.isEmpty(notifications.content) && TextUtils.isEmpty(notifications.name)) { // 有些手机有时会连续推二条,第一条为空的内容,第二条才是真正的信息
                    notificationRecord.addTime = 0L;
                }
                return Line.parse(notifications);

            case PackageMap.TYPE_NOTE_EMAIL_GMAIL:                                                  // GMail的消息都允许进来，不做时间间隔的处理
//                Logger.i(TAG, "Gmail过滤(邮件开关:" + SPUtil.INSTANCE.getEmailSwitch() + ")");
                notificationRecord.addTime = 0L;
                return GMail.parse(notifications) && true;

            case PackageMap.TYPE_NOTE_EMAIL_GOOGLE_INBOX:
                Logger.i(TAG, "Google Inbox过滤");
                notificationRecord.addTime = 0L;                                                    // Google Inbox的消息都允许进来，不做时间间隔的处理
                return GoogleInBox.parse(notifications);

            case PackageMap.TYPE_NOTE_EMAIL_OUTLOOK:
                Logger.i(TAG, "Outlook过滤");
                notificationRecord.addTime = 0L;
                return Outlook.parse(notifications);

            case PackageMap.TYPE_NOTE_EMAIL_OUTLOOK_EX:
                Logger.i(TAG, "OutlookEx Ex过滤");
                notificationRecord.addTime = 0L;
                return OutlookEx.parse(notifications);

            case PackageMap.TYPE_NOTE_CALENDAR:
                Logger.i(TAG, "Calendar过滤");
                notificationRecord.addTime = 0L;                                                    // 相同时间的周期性提醒
                return false;

            case PackageMap.TYPE_NOTE_EMAIL_QQ:
                Logger.i(TAG, "QQ邮件过滤");
                return QQEmail.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_QQ:
                Logger.i(TAG, "QQ过滤");
                return QQ.parse(notifications);

            case PackageMap.TYPE_NOTE_WECHAT:
                Logger.i(TAG, "微信过滤");
                return WeChat.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_VIBER:
                Logger.i(TAG, "Viber过滤");
                notificationRecord.addTime = 0L;
                return Viber.parse(notifications);

            case PackageMap.TYPE_NOTE_SOCIAL_LINKEDIN:
                Logger.i(TAG, "Linkedin过滤");
                return Linkedin.parse(notifications);

            case PackageMap.TYPE_NOTE_GOOGLE_MAP:
                Logger.i(TAG, "GoogleMap过滤");
                return GoogleMap.parse(notifications);

            case PackageMap.TYPE_NOTE_KAKAO_TALK:
                Logger.i(TAG, "KakaoTalk过滤");
                return KakaoTalk.parse(notifications);

            case PackageMap.TYPE_NOTE_TYPE_TELEGRAM:
                Logger.i(TAG, "Telegram 过滤");
                notificationRecord.addTime = 0L;
                return Telegram.parse(notifications);
        }
        return true;
    }

    public boolean checkIsSupportReply(String note) {
        if (TextUtils.isEmpty(note)) return false;
        switch (note) {
            case PackageMap.TYPE_NOTE_SOCIAL_FACEBOOK_MESSENGER:
                return true;
            case PackageMap.TYPE_NOTE_SOCIAL_LINE:
                return true;
            case PackageMap.TYPE_NOTE_TYPE_TELEGRAM:
                return true;
            case PackageMap.TYPE_NOTE_SOCIAL_VIBER:
                return true;
        }
        return false;
    }
}
