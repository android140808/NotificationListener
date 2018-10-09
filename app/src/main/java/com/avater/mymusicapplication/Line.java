package com.avater.mymusicapplication;


import android.text.TextUtils;

/**
 * Created by LL on 2018/3/6.
 */

public class Line {
    /**
     *
     * @param notifications
     * @return
     */
    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content))
            return false;

        if (notifications.content.contains(":")) {
            notifications.content = notifications.content.split(":")[1];
        }

        if (notifications.title.equalsIgnoreCase("LINE")) {
            if (notifications.name.contains(":"))
                notifications.name = notifications.name.split(":")[0];
            notifications.title = notifications.name;
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
