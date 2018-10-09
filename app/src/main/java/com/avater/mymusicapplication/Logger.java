package com.avater.mymusicapplication;


import android.util.Log;


public class Logger {
    /**
     * whether print log info
     */
    public static boolean weatherPrint = true;
    static String className;//类名
    static String methodName;//方法名
    static int lineNumber;//行数

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append(log);
        return buffer.toString();
    }

    public static void d(String tag, String msg) {
        if (!weatherPrint)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className + tag, createLog(msg));
    }

    public static void v(String tag, String msg) {
        if (!weatherPrint)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className + tag, createLog(msg));
    }

    public static void i(String tag, String msg) {

        if (!weatherPrint)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className + tag, createLog(msg));
    }

    public static void w(String tag, String msg) {

        if (!weatherPrint)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className + tag, createLog(msg));
    }

    public static void e(String tag, String msg) {

        if (!weatherPrint)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.e(className + tag, createLog(msg));
    }

    public static boolean isLoggable(String tag, int level) {
        //return Log.isLoggable(tag.substring(0, Math.min(23, tag.length())), level);
        return true;
    }
}

