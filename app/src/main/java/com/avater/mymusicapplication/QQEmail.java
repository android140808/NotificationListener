package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：
 */

public class QQEmail {

    private static String[] interceptTextArray = new String[]{
            "正在发送",
            "邮件发送"
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        if (!notifications.content.contains(":")) {
            LogUtil.i("NotificationReceiveService", "QQ邮箱发送邮件时内容不包含:,不推送!");
            return false;
        }
        for (String interceptText : interceptTextArray) {
            if (notifications.content.contains(interceptText)) {
                LogUtil.i("NotificationReceiveService", "QQ邮箱发送邮件时会监听到邮件推送通知,不推送!");
                return false;
            }
        }
        if (notifications.content.contains(":")) {                                                  // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        } else if (notifications.name.contains(":")) {
            notifications.title = notifications.name.split(":")[0];
            if (!notifications.text.startsWith(notifications.title) && !TextUtils.isEmpty(notifications.text)) {
                notifications.content = notifications.text;
            } else if (notifications.text.startsWith(notifications.title)) {
                notifications.content = notifications.text.substring(notifications.title.length() + 1);
            }
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
