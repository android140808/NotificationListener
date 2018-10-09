package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：zkx
 * 日期：2017/8/18
 * 说明：
 */

public class Facebook {
    private static String[] interceptTextArray = new String[]{
            "轻触可查看选项",
            "點按查看選項",
            "Tap for options",
            "Appuyez pour afficher les options",
            "你有&条新通知"                                                                           // 过滤类似于"Du Zhe，你有26条新通知"
    };

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        for (String interceptText : interceptTextArray) {
            if (interceptText.contains("&")) {                                                      // 多条件过滤，content必须包含所有的过滤条件才可以过滤该通知
                boolean containFlag = true;
                for (String str : interceptText.split("&")) {
                    if (!notifications.content.contains(str)) {
                        containFlag = false;
                        break;
                    }
                }
                if (containFlag) {
                    LogUtil.i("NotificationReceiveService", "不推送该条Facebook消息(" + notifications.content + ")");
                    return false;
                }
            } else if (notifications.content.contains(interceptText)) {
                LogUtil.i("NotificationReceiveService", "不推送该条Facebook消息(" + notifications.content + ")");
                return false;
            }
        }

        // {packageName='com.facebook.katana', content='你有新的推荐好友：杨庆。', timeStamp=1514432705292, title='Facebook', name='Facebook: ', text='你有新的推荐好友：杨庆。', summaryText='', bigText='', line='', progress='0', progressMax='0'}
        // {packageName='com.facebook.katana', content='陈佳佳向你发送了加好友请求。', timeStamp=1514441464990, title='Facebook', name='Facebook: ', text='陈佳佳向你发送了加好友请求。', summaryText='', bigText='', line='', progress='0', progressMax='0'}
        // {packageName='com.facebook.katana', content='洛洛给你发了一条消息。', timeStamp=1517639163426, title='Facebook', name='洛洛: ', text='洛洛发送了消息。', summaryText='', bigText='洛洛发送了消息。', line='', progress='0', progressMax='0'}//
        if (notifications.name.contains(":") && !notifications.name.split(":")[0].equals(notifications.title)) {
            notifications.title = notifications.name.split(":")[0];
            if (!notifications.text.startsWith(notifications.title) && !TextUtils.isEmpty(notifications.text)) {
                notifications.content = notifications.text;
            }
//            else if (notifications.text.startsWith(notifications.title)) {//这里有问题
//                notifications.content = notifications.text.substring(notifications.title.length() + 1);
//            }
        } else if (notifications.content.contains(":")) {                                                  // 把姓名赋值给title，其余是内容
            notifications.title = notifications.content.split(":")[0];
            notifications.content = notifications.content.substring(notifications.title.length() + 1);
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
