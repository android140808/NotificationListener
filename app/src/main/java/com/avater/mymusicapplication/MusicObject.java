package com.avater.mymusicapplication;

/**
 * Created by Administrator on 2018/9/28.
 */

public class MusicObject {
    private String packAgeName;
    private int type;
    private int commandType;

    public MusicObject() {
    }

    public MusicObject(String packAgeName, int type, int commandType) {
        this.packAgeName = packAgeName;
        this.type = type;
        this.commandType = commandType;
    }

    public String getPackAgeName() {
        return packAgeName;
    }

    public void setPackAgeName(String packAgeName) {
        this.packAgeName = packAgeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }
}
