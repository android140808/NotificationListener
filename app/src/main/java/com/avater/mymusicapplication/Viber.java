package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：zkx
 * 日期：2017/9/13
 * 说明：
 */

public class Viber {

    public static boolean parse(Notifications notifications) {
        if (notifications.text.contains("\n\n")) {
            LogUtil.i("NotificationReceiveService", "过滤连续发送的信息以连续换二行拼接在一起的信息");
            return false;
        }

        if (notifications.name.contains(":")) {
            notifications.title = notifications.name.split(":")[0];
            if (!notifications.text.startsWith(notifications.title) && !TextUtils.isEmpty(notifications.text)) {
                notifications.content = notifications.text;
            } else if (notifications.text.startsWith(notifications.title)) {
                notifications.content = notifications.text.substring(notifications.title.length() + 1);
            }
        } else if (notifications.content.contains(":")) {                                                  // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        }
        return !TextUtils.isEmpty(notifications.content) && !notifications.isOngoing;
    }
}
