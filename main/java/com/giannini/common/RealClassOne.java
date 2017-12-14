package com.giannini.common;

/**
 * @author jiangningyu
 * @date 2017/12/8
 */
public class RealClassOne extends AbstractTestClass {
    @Override
    protected void doyourself() {
        System.out.println(this.getClass().getSimpleName());
    }
}
