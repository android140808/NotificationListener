package com.avater.mymusicapplication;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by LL on 2018/2/28.
 */

public class ApplicationInfo implements Serializable {
    public String appName;
    public String pkgName;
    public Drawable iconDrawable;
    public int shockRingType;                                                                       // 震动闹铃模式，为负数时，模式为正数时的模式，但开关是关闭的；为0时没有震动模式，开关关闭；为正数时则开启相应的震动模式

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "appName=" + appName +
                ", pkgName='" + pkgName + '\'' +
                ", shockRingType='" + shockRingType + '\'' +
                '}';
    }
}
