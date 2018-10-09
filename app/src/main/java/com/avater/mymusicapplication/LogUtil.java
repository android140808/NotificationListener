package com.avater.mymusicapplication;

import android.text.TextUtils;


/**
 * 作者：hsh
 * 日期：2017/3/21
 * 说明：日志打印类(所有的日志都用该类来管理)
 */

public class LogUtil {
    private static ILogPrintfCall logPrintfCall;

    /**
     * 需要在P层初始化，M层才能进行打印
     *
     * @param logPrintfCall P实现该接口，用于M层调用
     */
    public static void init(ILogPrintfCall logPrintfCall) {
        LogUtil.logPrintfCall = logPrintfCall;
    }

    /**
     * 销毁
     */
    public static void onDestroy() {
        logPrintfCall = null;
    }

    /**
     * 打印info类消息
     *
     * @param TAG 类名
     * @param msg 消息
     */
    public static void i(String TAG, String msg) {
        if (logPrintfCall != null)
            logPrintfCall.iPrintf(TAG, msg);
    }

    /**
     * 打印info类消息(不需要传类名，并包含行号打印)
     *
     * @param msg 消息
     */
    public static void i(String msg) {
        printfClassNameAndLineNumber(new Throwable().getStackTrace(), msg, "i");
    }

    /**
     * 打印warn类消息
     *
     * @param TAG 类名
     * @param msg 消息
     */
    public static void w(String TAG, String msg) {
        if (logPrintfCall != null)
            logPrintfCall.wPrintf(TAG, msg);
    }

    /**
     * 打印warn类消息(不需要传类名，并包含行号打印)
     *
     * @param msg 消息
     */
    public static void w(String msg) {
        printfClassNameAndLineNumber(new Throwable().getStackTrace(), msg, "w");
    }

    /**
     * 打印error类消息
     *
     * @param TAG 类名
     * @param msg 消息
     */
    public static void e(String TAG, String msg) {
        if (logPrintfCall != null)
            logPrintfCall.ePrintf(TAG, msg);
    }

    /**
     * 打印error类消息(不需要传类名，并包含行号打印)
     *
     * @param msg 消息
     */
    public static void e(String msg) {
        printfClassNameAndLineNumber(new Throwable().getStackTrace(), msg, "e");
    }

    /**
     * 打印verbose类消息
     *
     * @param TAG 类名
     * @param msg 消息
     */
    public static void v(String TAG, String msg) {
        if (logPrintfCall != null)
            logPrintfCall.vPrintf(TAG, msg);
    }

    /**
     * 打印verbose类消息(不需要传类名，并包含行号打印)
     *
     * @param msg 消息
     */
    public static void v(String msg) {
        printfClassNameAndLineNumber(new Throwable().getStackTrace(), msg, "v");
    }

    // 打印类名和行号综合处理
    private static void printfClassNameAndLineNumber(StackTraceElement[] sElements, String msg, String type) {
        String className = sElements[1].getFileName();
        int lineNumber = sElements[1].getLineNumber();
        if (!TextUtils.isEmpty(className)) {
            msg = "[第" + lineNumber + "行] " + msg;
            switch (type) {
                case "w":
                    w(className, msg);
                    break;
                case "e":
                    e(className, msg);
                    break;
                case "v":
                    v(className, msg);
                    break;
                default:
                    i(className, msg);
                    break;
            }
        }
    }
}
