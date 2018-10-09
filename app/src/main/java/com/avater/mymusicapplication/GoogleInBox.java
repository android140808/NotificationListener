package com.avater.mymusicapplication;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2017/10/27
 * 说明：GMail的一封邮件会有两条通知，第一条是无用的(content包含@gmail.com bigText为空)，第二条才是需要的
 */

public class GoogleInBox {
    private static List<Integer> crcList = new ArrayList<>();

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content)) return false;
        if (notifications.content.contains("@gmail.com")) {                                         // 如果包含@gmail.com，很有可能是第一条无用的信息，这时需要把addTime重置
            return false;
        }
        notifications.content = TextUtils.isEmpty(notifications.bigText) ? notifications.content : notifications.bigText;
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
