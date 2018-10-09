package com.avater.mymusicapplication;


import android.text.TextUtils;

/**
 * 作者：zkx
 * 日期：2017/9/13
 * 说明：
 */

public class Linkedin {

    public static boolean parse(Notifications notifications) {
        if (!TextUtils.isEmpty(notifications.content) && !TextUtils.isEmpty(notifications.name)) {
            notifications.content = notifications.name + notifications.content;
        }

        return !TextUtils.isEmpty(notifications.content);
    }
}
