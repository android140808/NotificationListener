package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2017/11/14
 * 说明：
 */

public class Outlook {

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        if (!TextUtils.isEmpty(notifications.line) && notifications.line.contains(" ")) {
            String sender = notifications.line.split(" ")[0];
            String content = notifications.line.split(" ")[1];
            if (!TextUtils.isEmpty(sender) &&
                    !TextUtils.isEmpty(content) &&
                    sender.contains("@") &&
                    sender.contains("\"")) {                                                        // 如: "abc@appscomm.cn" 主题
                notifications.title = sender.replace("\"", "");
                notifications.content = notifications.line.substring(sender.length());
            }
        }
        return true;
    }
}
