package com.avater.mymusicapplication;

import android.widget.RemoteViews;

/**
 * 作者：hsh
 * 日期：2017/4/24
 * 说明：自定义的通知消息(适用于消息推送和歌曲名的获取)
 */

public class Notifications {
    public String packageName = "";                                                                 // 包名
    public String content = "";                                                                     // 内容
    public long timeStamp = 0L;                                                                     // 时间戳
    public String title = "";                                                                       // 标题
    public String name = "";                                                                        // 名称
    public String text = "";                                                                        // 文本
    public String summaryText = "";                                                                 // 文本1
    public String bigText = "";                                                                     // 大文本
    public String line = "";
    public int progress;
    public int progressMax;
    public RemoteViews remoteViews;
    public boolean isOngoing;

    @Override
    public String toString() {
        return "Notifications{" +
                "packageName='" + packageName + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", summaryText='" + summaryText + '\'' +
                ", bigText='" + bigText + '\'' +
                ", line='" + line + '\'' +
                ", progress='" + progress + "\'" +
                ", progressMax='" + progressMax + "\'" +
                '}';
    }
}
