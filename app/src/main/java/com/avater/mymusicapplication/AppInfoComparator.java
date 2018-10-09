package com.avater.mymusicapplication;

import java.util.Comparator;

/**
 * Created by LL on 2018/3/1.
 */

public class AppInfoComparator implements Comparator<ApplicationInfo> {
    @Override
    public int compare(ApplicationInfo o1, ApplicationInfo o2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.appName, o2.appName);
        return res == 0 ? o1.appName.compareToIgnoreCase(o2.appName) : res;
    }
}
