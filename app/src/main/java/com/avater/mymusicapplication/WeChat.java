package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2017/7/14
 * 说明：
 */

public class WeChat {
    private static String[] interceptTextArray = new String[]{
            "Touch for more information or to stop the app",
            "触控来取得更多信息",
            "触摸即可了解详情或停止应用",
            "QQ邮箱提醒",
            "点按即可了解",
            "Appuyez ici pour en savoir plus ou arrêter l'application."
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        for (String interceptText : interceptTextArray) {
            if (notifications.content.contains(interceptText)) {
                LogUtil.i("NotificationReceiveService", "不推送该条微信消息(" + notifications.content + ")");
                return false;
            }
        }
        if (notifications.content.contains(":")) {                                                  // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
