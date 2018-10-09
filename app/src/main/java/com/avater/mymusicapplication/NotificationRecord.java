package com.avater.mymusicapplication;

/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：
 */

public class NotificationRecord {

    public int notificationCount = 0;
    public byte notificationType;
    public long addTime;
    public long removeTime;
    public String note;

    public NotificationRecord(byte notificationType) {
        this.notificationType = notificationType;
        this.notificationCount = 0;
    }

    public NotificationRecord(byte notificationType, String note) {
        this.notificationType = notificationType;
        this.notificationCount = 0;
        this.note = note;
    }
}
