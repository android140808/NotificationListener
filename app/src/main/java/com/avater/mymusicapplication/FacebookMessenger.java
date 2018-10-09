package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：
 */

public class FacebookMessenger {

    private static String[] interceptTextArray = new String[]{
            "Chat heads active:",
            "Bulles de discussion activées:",
            "浮动聊天头像使用中:",
            "聊天大頭貼使用中:"
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        for (String interceptText : interceptTextArray) {
            if (notifications.content.contains(interceptText)) {
                LogUtil.i("NotificationReceiveService", "不推送该条FacebookMessenger消息(" + notifications.content + ")");
                return false;
            }
        }

        // {packageName='com.facebook.orca', content='1个对话', timeStamp=1514441699076, title='Messenger', name='浮动聊天头像使用中: ', text='1个对话', summaryText='', bigText='', line='', progress='0', progressMax='0'}
        // {packageName='com.facebook.orca', content='陈佳佳：Dhjv', timeStamp=1514441983260, title='Messenger', name='陈佳佳: ', text='Dhjv', summaryText='', bigText='Dhjv', line='', progress='0', progressMax='0'}
        if (notifications.name.contains(":")) {
            notifications.title = notifications.name.split(":")[0];
            if (!notifications.text.startsWith(notifications.title) && !TextUtils.isEmpty(notifications.text)) {
                notifications.content = notifications.text;
            } else if (notifications.text.startsWith(notifications.title)) {
                notifications.content = notifications.text.substring(notifications.title.length() + 1);
            }
        } else if (notifications.content.contains(":")) {                                           // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
