package com.avater.mymusicapplication;

/**
 * 作者：hsh
 * 日期：2017/5/26
 * 说明：
 */

public interface ILogPrintfCall {
    void iPrintf(String TAG, String msg);

    void wPrintf(String TAG, String msg);

    void ePrintf(String TAG, String msg);

    void vPrintf(String TAG, String msg);
}
