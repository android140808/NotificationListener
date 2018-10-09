package com.avater.mymusicapplication;

import android.app.Application;

/**
 * Created by Administrator on 2018/9/21.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MessagePush.INSTANCE.init(this);
        MusicControl.INSTANCE.init(getApplicationContext());
    }
}
