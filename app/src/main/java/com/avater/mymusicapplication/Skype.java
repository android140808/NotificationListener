package com.avater.mymusicapplication;


import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：
 */

public class Skype {
    private static List<Integer> crcList = new ArrayList<>();
    
    public static boolean parse(Notifications notifications) {
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

        int crc = CRCUtil.stringToCRC16(notifications.content);
        if (crcList == null)
            crcList = new ArrayList<>();
        if (crcList.contains(crc)) {
            LogUtil.e("NotificationReceiveService", "之前已经发送过这Skype信息了...");
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
