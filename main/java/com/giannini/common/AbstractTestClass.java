package com.giannini.common;

/**
 * @author jiangningyu
 * @date 2017/12/8
 */
public abstract class AbstractTestClass implements TestIF {

    @Override
    public void action() {
        dolog();
        doyourself();
    }

    protected abstract void doyourself();

    protected void dolog() {
        System.out.println(this.getClass().getName());
    }
}
