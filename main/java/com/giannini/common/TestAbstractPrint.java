package com.giannini.common;

/**
 * @author jiangningyu
 * @date 2017/12/8
 */
public class TestAbstractPrint {

    public static void main(String[] args) {
        TestIF ti = new RealClassOne();
        ti.action();
    }
}
