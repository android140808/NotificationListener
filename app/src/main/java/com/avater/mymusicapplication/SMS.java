package com.avater.mymusicapplication;

import android.text.TextUtils;


/**
 * Created by LL on 2018/2/6.
 */

public class SMS {
    private static String[] interceptTextArray = new String[]{
            "正在呼叫",
            "视频呼叫",
            "Calling",
            "Video calling",
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        if (!notifications.content.startsWith(notifications.name)) {
            return false;
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
