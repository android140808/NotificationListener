package com.avater.mymusicapplication;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：WhatsApp 同样的内容会发照片四条，文字、音频、语音通话、语音留言、视频两条，未接语言通话、未接视频通话一条
 */

public class WhatsApp {
    private static List<Integer> crcList = new ArrayList<>();
    public static boolean parse(Notifications notifications) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            notifications.name = notifications.name.replace(":", "").trim();
//            LogUtil.i("NotificationReceiveService", "notifications----：" + notifications.content + "," + notifications.name);
            if (TextUtils.isEmpty(notifications.summaryText) && notifications.content.equals(notifications.name)) {                                     // 对于whatApp来说,summaryText装的是xx条消息,如果不为空则不推送
                LogUtil.i("NotificationReceiveService", "whatApp推送的是xxx条消息,不推送给设备...!!!");
                return false;
            }
            notifications.text = TextUtils.isEmpty(notifications.bigText) ? notifications.text : notifications.bigText;
        }
        notifications.title = TextUtils.isEmpty(notifications.name) ? notifications.title : notifications.name.replace(":", "");
        if (!TextUtils.isEmpty(notifications.bigText)) {
            LogUtil.i("NotificationReceiveService", "whatApp推送的第一条消息");
//            notifications.content = TextUtils.isEmpty(notifications.text) ? notifications.content : (notifications.name + notifications.text);
            notifications.content = TextUtils.isEmpty(notifications.text) ? notifications.content : notifications.text;
        } else {
            LogUtil.i("NotificationReceiveService", "whatApp推送的不是第一条消息");
//            notifications.content = TextUtils.isEmpty(notifications.line) ? notifications.content : (notifications.name + notifications.line);
            if (!TextUtils.isEmpty(notifications.line)) {
                if (notifications.name.contains("WhatsApp") && notifications.line.contains(":")) {  // 例如 line='duzhe: lllll' name='WhatsApp: 一次性发送多条whatapp的情况(包含历史已经发过了的)
                    notifications.title = notifications.line.split(":")[0];
                    notifications.line = notifications.line.split(":")[1];
                } else if (notifications.title.contains("WhatsApp") && notifications.name.contains(":") && !notifications.line.contains(":")) {
                    notifications.title = notifications.name.split(":")[0];                         // 例如 title='WhatsApp', name='‪+86 185 8826 8559‬: ', text='2 条新信息', summaryText='2 条新信息', bigText='', line='Asda',
                }
                notifications.content = notifications.line;                                         // 一次发两条，不包含历史已经发过的即 line='lllll'
            }
        }

        //以下是原来带的
        if (TextUtils.isEmpty(notifications.content) && !TextUtils.isEmpty(notifications.text)) {
            notifications.content = notifications.text;
        }
        notifications.content = notifications.content.replace("WhatsApp:", "").trim();
        LogUtil.i("TAG", ">>" + notifications.toString());
        int crc = CRCUtil.stringToCRC16(notifications.content);
        if (crcList == null)
            crcList = new ArrayList<>();
        if (crcList.contains(crc)) {
            LogUtil.e("NotificationReceiveService", "之前已经发送过这封GMail邮件了...");
            return false;
        }
        crcList.add(crc);
        return !TextUtils.isEmpty(notifications.content);
    }

    public static void clearCRC() {
        if (crcList == null)
            crcList = new ArrayList<>();
        crcList.clear();
    }
}
