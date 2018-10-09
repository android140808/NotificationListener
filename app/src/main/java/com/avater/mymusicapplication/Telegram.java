package com.avater.mymusicapplication;

import android.text.TextUtils;

/**
 * Created by LL on 2018/3/1.
 */

public class Telegram {

    /**
     * //发送方：:Notifications{packageName='org.telegram.messenger', content='Jane: Gygughjgj', timeStamp=1519869109370, title='Telegram', name='Jane: ', text='李', summaryText='李', bigText='', line='La', progress='0', progressMax='0'}
     * //接收方 ：Notifications{packageName='org.telegram.messenger', content='李LL: 啦啦啦', timeStamp=1519869123493, title='Telegram', name='李LL: ', text='啦啦啦', summaryText='', bigText='啦啦啦', line='', progress='0', progressMax='0'}
     *
     * @param notifications
     * @return
     */
    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content) || (!TextUtils.isEmpty(notifications.line) && notifications.summaryText.equals("Yay")))
            return false;

        if (notifications.content.contains(notifications.name)) {
            notifications.content = notifications.content.split(notifications.name)[1];
        }

        if (notifications.title.equals("Telegram")) {
            if (notifications.name.contains(":"))
                notifications.name = notifications.name.split(":")[0];
            notifications.title = notifications.name;
        }
        return !TextUtils.isEmpty(notifications.content);
    }
}
