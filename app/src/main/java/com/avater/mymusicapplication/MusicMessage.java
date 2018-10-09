package com.avater.mymusicapplication;

/**
 * 作者:Avater
 * 日期： 2017-12-20.
 * 说明：SpotifyMusic 歌曲消息类
 */

public class MusicMessage {
    private String packageName;
    private String tittle;
    private String content;
    private long timeStamp;
    private String name;
    private String text;

    public MusicMessage() {
    }

    public MusicMessage(String packageName, String tittle, String content, long timeStamp, String name, String text) {
        this.packageName = packageName;
        this.tittle = tittle;
        this.content = content;
        this.timeStamp = timeStamp;
        this.name = name;
        this.text = text;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MusicMessage{" +
                "packageName='" + packageName + '\'' +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
