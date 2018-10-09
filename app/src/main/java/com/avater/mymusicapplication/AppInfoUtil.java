package com.avater.mymusicapplication;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 作者：hsh
 * 日期：2018/3/28
 * 说明：该类主要是区分出哪些app是系统的，哪些是需要的
 */

public enum AppInfoUtil {
    INSTANCE;

    private List<String> unwantedPackageNameList = new ArrayList<>();                               // 不需要的系统app
    private List<String> necessaryPackageNameList = new ArrayList<>();                              // 需要的可能是系统的app
    public List<ApplicationInfo> wantedPackageNameList = new ArrayList<>();                         // 需要的APP
    public static int FLAG_SYSTEM_APP = 1;
    public static int FLAG_USER_APP = 2;

    public List<String> getUnwantedPackageNameList() {
        if (unwantedPackageNameList.size() == 0) {
            refreshPackageNameList();
        }
        return unwantedPackageNameList;
    }

    public List<ApplicationInfo> getWantedPackageNameList() {
        if (wantedPackageNameList.size() == 0) {
            refreshPackageNameList();
        }
        return wantedPackageNameList;
    }

    public int checkPackageNameType(String packageName) {
        if (unwantedPackageNameList.size() == 0 || wantedPackageNameList.size() == 0) {
            refreshPackageNameList();
        }
        int type = getPackageNameType(packageName);
        if (type == -1) {
            refreshPackageNameList();
            type = getPackageNameType(packageName);
        }
        return type;
    }

    /**
     * 刷新包名集合(分出那些是不需要的包名 那些是需要的包名)，比较耗时，慎重使用
     */
    public void refreshPackageNameList() {
        initNecessaryPackageNameList();
        ApplicationInfo applicationInfo;
        wantedPackageNameList.clear();
        unwantedPackageNameList.clear();
        unwantedPackageNameList.add("com.google.android.calendar");
        unwantedPackageNameList.add("com.android.calendar");
        unwantedPackageNameList.add("com.htc.calendar");
        unwantedPackageNameList.add("com.samsung.android.calendar");
        unwantedPackageNameList.add("com.bbk.calendar");
        unwantedPackageNameList.add("mikado.bizcalpro");
        unwantedPackageNameList.add("cn.nubia.calendar.preset");
        unwantedPackageNameList.add("netgenius.bizcal");
        try {
            PackageManager packageManager = MessagePush.INSTANCE.getContext().getPackageManager();
            List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
            for (PackageInfo packageInfo : packageInfoList) {
                String packageName = packageInfo.packageName;
                boolean isUnwantedPackageFlag = false;
                if (packageName.contains("email")) {
                    Logger.i("testMessage", "这个有邮箱:" + packageName);
                }
                if ((android.content.pm.ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != 0 &&       // 系统应用
                        !(necessaryPackageNameList.contains(packageName) || packageName.contains("com.skype") || packageName.contains("mail") || packageName.contains("email"))) { // 不包含有用的包
                    isUnwantedPackageFlag = true;
                }
                if (isUnwantedPackageFlag && !unwantedPackageNameList.contains(packageName)) {
                    unwantedPackageNameList.add(packageName);
                }
                if (!isUnwantedPackageFlag) {
                    String appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    if (appName.startsWith("com")) continue;
                    applicationInfo = new ApplicationInfo();
                    applicationInfo.pkgName = packageName;
                    applicationInfo.appName = appName;
                    applicationInfo.appName = applicationInfo.appName.startsWith(" ") ? applicationInfo.appName.split(" ")[1] : applicationInfo.appName;
                    try {
                        applicationInfo.iconDrawable = packageInfo.applicationInfo.loadIcon(packageManager);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                    }

//                    int type = SPUtil.INSTANCE.getAppShockRingType(packageName);
                    int type = 1;
                    applicationInfo.shockRingType = (type == -100 ? 2 : type); // 默认是单次短震动
                    wantedPackageNameList.add(applicationInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wantedPackageNameList != null && wantedPackageNameList.size() > 0) {
            Collections.sort(wantedPackageNameList, new AppInfoComparator());
            saveSP();
        }
    }

    private void saveSP() {
        if (wantedPackageNameList != null && wantedPackageNameList.size() > 0) {
            for (ApplicationInfo applicationInfo : wantedPackageNameList) {
                String key = applicationInfo.pkgName;
                if (!TextUtils.isEmpty(key)) {
//                    int shockRingType = SPUtil.INSTANCE.getAppShockRingType(key);
                    int shockRingType = 1;
                    if (shockRingType == -100) {                                                    // sp中没有保存该值
//                        SPUtil.INSTANCE.setAppShockRingType(key, 2);
                    }
                }
            }
        }
    }

    private void initNecessaryPackageNameList() {
        if (necessaryPackageNameList.size() == 0) {
            necessaryPackageNameList.add("com.facebook.orca");                                      // 系统彩信
            necessaryPackageNameList.add("com.facebook.katana");
            necessaryPackageNameList.add("com.google.android.gm");
            necessaryPackageNameList.add("com.google.android.googlequicksearchbox");
            necessaryPackageNameList.add("com.google.android.apps.photos");
            necessaryPackageNameList.add("com.google.android.apps.docs");
            necessaryPackageNameList.add("com.google.android.apps.walletnfcrel");
            necessaryPackageNameList.add("com.google.android.apps.fitness");
            necessaryPackageNameList.add("com.google.android.music");
            necessaryPackageNameList.add("com.android.vending");
            necessaryPackageNameList.add("com.google.android.play.games");
            necessaryPackageNameList.add("com.google.android.videos");
            necessaryPackageNameList.add("com.google.android.talk");
            necessaryPackageNameList.add("com.google.android.youtube");
            necessaryPackageNameList.add("com.google.android.apps.maps");
            necessaryPackageNameList.add("com.samsung.voiceserviceplatform");
            necessaryPackageNameList.add("com.samsung.android.app.watchmanager");
            necessaryPackageNameList.add("com.samsung.android.voc");
            necessaryPackageNameList.add("com.samsung.android.spay");
            necessaryPackageNameList.add("com.samsung.android.email.provider");
            necessaryPackageNameList.add("com.android.email");
            necessaryPackageNameList.add("com.whatsapp");
            necessaryPackageNameList.add("com.instagram.android");
            necessaryPackageNameList.add("com.skype");
            necessaryPackageNameList.add("com.twitter.android");
            necessaryPackageNameList.add("jp.naver.line.android");
            necessaryPackageNameList.add("com.viber.voip");
            necessaryPackageNameList.add("com.kakao.talk");
            necessaryPackageNameList.add("com.andguru.telegram.messenger");
            necessaryPackageNameList.add("com.sec.android.app.shealth");
            necessaryPackageNameList.add("com.htc.android.mail");
            necessaryPackageNameList.add("com.sonyericsson.extras.liveware.extension.mail");
        }
    }

    private int getPackageNameType(String packageName) {
        if (unwantedPackageNameList.contains(packageName)) {
            return FLAG_SYSTEM_APP;
        }
        for (ApplicationInfo applicationInfo : wantedPackageNameList) {
            if (applicationInfo.pkgName.equals(packageName)) {
                return FLAG_USER_APP;
            }
        }
        return -1;
    }
}
