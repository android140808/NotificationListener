package com.avater.mymusicapplication;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.RemoteViews;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * 作者：hsh
 * 日期：2017/11/7
 * 说明：
 */

public class GoogleMap {

    public static boolean parse(Notifications notifications) {
        if (TextUtils.isEmpty(notifications.content) || TextUtils.isEmpty(notifications.bigText)) {
            try {
                String myContent = parseGoogleMapsNotification(notifications.remoteViews);
                if (!TextUtils.isEmpty(myContent)) {
                    notifications.content = myContent;
                }
                LogUtil.i("NotificationReceiveService", "GoogleMap通过反射获取到的内容是:" + notifications.content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (TextUtils.isEmpty(notifications.content)) return false;
            if (TextUtils.isEmpty(notifications.bigText)) {                                             // 如正在重选路线...
                LogUtil.e("NotificationReceiveService", "GoogleMap无用信息,不用推送");
                return false;
            }
            if (notifications.progressMax > 0) {                                                        // 正在下载
                LogUtil.e("NotificationReceiveService", "谷歌地图正在下载,不用推送");
                return false;
            }

            notifications.content = notifications.bigText;
            notifications.title = TextUtils.isEmpty(notifications.name) ? notifications.title : notifications.name.replace(":", "");
        }
        return !TextUtils.isEmpty(notifications.content);
    }

    private static String parseGoogleMapsNotification(RemoteViews views) {

        //從 bigContentView 取得訊息．含有訊息的還有 contentView, headsupContentView．
        Class secretClass = views.getClass();

        //因為 Google Maps 把所有內容藏在 RemoteViews 裡面，因此只能用 Reflection 硬是把內容取出...
        //此方式具有一定程度的危險性．但也是唯一的方式
        try {
            Field outerFields[] = secretClass.getDeclaredFields();
            for (int i = 0; i < outerFields.length; i++) {
                if (!outerFields[i].getName().equals("mActions")) continue;
                outerFields[i].setAccessible(true);
                ArrayList<Object> actions = (ArrayList<Object>) outerFields[i].get(views);

                //有用的訊息集中在 index 4, 5, 6. 目前不確定是否所有手機皆相同．

                //取得下一段路口的距離資訊
                Object distanceAction = actions.get(4);

                //取得下一段路口的名稱
                Object directionAction = actions.get(5);

                //到達目的地的預定時間
                Object estimationAction = actions.get(6);

                //getValue 是自己寫的 function
                Object valueForDistance = getValue(distanceAction);
                Object valueForDirection = getValue(directionAction);
                Object valueForEstimation = getValue(estimationAction);

                //取得的「下一段路口的距離資訊」和「下一段路口的名稱」都是 SpannableString
                SpannableString realValueForDistance = (SpannableString) valueForDistance;
                SpannableString realValueForDirection = (SpannableString) valueForDirection;

                //打印
//                LogUtil.i("NotificationReceiveService", realValueForDistance.toString() + " - " + realValueForDirection);
                return realValueForDistance.toString() + " - " + realValueForDirection;
            }
        } catch (Exception exception) {
            LogUtil.i("NotificationReceiveService", "Exception while doing reflection");
        }
        return null;
    }

    private static Object getValue(Object action) {
        Field innerFields[] = action.getClass().getDeclaredFields();
        Object returnedObject = null;
        for (Field field : innerFields) {
            field.setAccessible(true);
//            String fieldName = field.getName();
//            LogUtil.i("NotificationReceiveService", fieldName);
            if (field.getName().equals("value")) {
                try {
                    returnedObject = field.get(action);
                } catch (IllegalAccessException exception) {
                    LogUtil.i("NotificationReceiveService", "IllegalAccessException while getting value");
                }
            }
        }

        return returnedObject;
    }
}
