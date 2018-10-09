package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * Created by LL on 2018/2/6.
 */

public class KakaoTalk {
    private static String[] interceptTextArray = new String[]{
            "正在呼叫",
            "视频呼叫",
            "Calling",
            "Video calling",
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        for (String interceptText : interceptTextArray) {
            if (notifications.content.contains(interceptText) || notifications.text.contains(interceptText)) {
                LogUtil.i("NotificationReceiveService", "不推送该条Facebook消息(" + notifications.content + ")");
                return false;
            }
        }

        if (notifications.name.contains(":") && !notifications.name.split(":")[0].equals(notifications.title)) {
            notifications.title = notifications.name.split(":")[0];
            if (!notifications.text.startsWith(notifications.title) && !TextUtils.isEmpty(notifications.text)) {
                notifications.content = notifications.text;
            }
        } else if (notifications.content.contains(":")) {                                                  // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        }

        return !TextUtils.isEmpty(notifications.content);
    }
}
