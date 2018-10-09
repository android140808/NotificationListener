package com.avater.mymusicapplication;

import android.text.TextUtils;


/**
 * 作者：zkx
 * 日期：2017/8/29
 * 说明：
 */

public class Twitter {

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;

        if (!(notifications.content.contains(":") || notifications.content.contains("："))) {
            LogUtil.i("NotificationReceiveService", "Twitter信息内容没有\":\"");
            // 过滤"正在发送推文…","推文已发送",...
            return false;
        }

        // {packageName='com.twitter.android', content='ko：Rggr', timeStamp=1514440729460, title='Twitter', name='ko: ', text='Rggr', summaryText='kx @kx34021883', bigText='', line='Yy7', progress='0', progressMax='0'}
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

        return !TextUtils.isEmpty(notifications.content);
    }
}
