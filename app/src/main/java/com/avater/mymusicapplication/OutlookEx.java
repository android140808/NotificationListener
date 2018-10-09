package com.avater.mymusicapplication;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2017/11/9
 * 说明：
 */

public class OutlookEx {
    private static List<Integer> crcList = new ArrayList<>();

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        if (TextUtils.isEmpty(notifications.bigText)) {                                             // 过滤"x 封邮件"消息
            LogUtil.e("NotificationReceiveService", "Outlook包含xxx封邮件,不能推送");
            return false;
        }
        notifications.content = notifications.bigText;
        if (notifications.content.startsWith(notifications.text)) {
            notifications.content = "[" + notifications.text + "]" + notifications.content.substring(notifications.text.length());
        }
        notifications.title = TextUtils.isEmpty(notifications.name) ? notifications.title : notifications.name.replace(":", "");
        int crc = CRCUtil.stringToCRC16(notifications.content);
        if (crcList == null)
            crcList = new ArrayList<>();
        if (crcList.contains(crc)) {
            LogUtil.e("NotificationReceiveService", "之前已经发送过这封GMail邮件了...");
            return false;
        }
        crcList.add(crc);
        return true;
    }

    public static void clearCRC() {
        if (crcList == null)
            crcList = new ArrayList<>();
        crcList.clear();
    }
}
