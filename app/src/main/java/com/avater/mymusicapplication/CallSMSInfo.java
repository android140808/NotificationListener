package com.avater.mymusicapplication;

/**
 * 作者：hsh
 * 日期：2017/4/20
 * 说明：
 */

public class CallSMSInfo {
    public String name;                                                                             // 姓名
    public String phoneNo;                                                                          // 电话号码
    public String content;                                                                          // 内容
    public long receiveTime;                                                                        // 时间
    public int callSMSCount;                                                                        // 电话或短信条数

    public CallSMSInfo() {
    }

    public CallSMSInfo(String name, String phoneNo, int callSMSCount) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.callSMSCount = callSMSCount;
    }

    @Override
    public String toString() {
        return "姓名:" + name + " 电话号码:" + phoneNo + " 内容:" + content;
    }
}
