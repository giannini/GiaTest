package com.giannini.common;

/**
 * Created by jiangningyu on 2017/10/27.
 */
public class TestStringFormat {

    public static void main(String[] args) {

        String formatStr = "低电车辆，电量%s%%，确定要开锁换电吗?";
        Integer batteryLevel = 30;
        String str = String.format(formatStr, batteryLevel);
        System.out.println(str);
    }
}
