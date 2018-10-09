package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * 作者：hsh
 * 日期：2017/7/18
 * 说明：
 */

public class QQ {

    private static String[] interceptTextArray = new String[]{
            "QQ正在后台运行",
            "你的帐号在电脑登录",
            "有&个联系人给你发过来&条新消息",                                                                     // 有 2 个联系人给你发过来7条新消息
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
                    Logger.i("NotificationReceiveService", "不推送该条QQ消息(多条件过滤:" + notifications.content + ")");
                    return false;
                }
            } else if (notifications.content.contains(interceptText)) {
                Logger.i("NotificationReceiveService", "不推送该条QQ消息(单条件过滤:" + notifications.content + ")");
                return false;
            }
        }
        // {packageName='com.tencent.mobileqq', content='☆焱 垚☆: abc', timeStamp=1514443851048, title='QQ', name='☆焱 垚☆: ', text='abc', summaryText='', bigText='', line='', progress='0', progressMax='0'}
        // {packageName='com.tencent.mobileqq', content='☆焱 垚☆: wee', timeStamp=1514444135037, title='QQ', name='QQ: ', text='有 2 个联系人给你发过来3条新消息', summaryText='', bigText='', line='', progress='0', progressMax='0'}
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
