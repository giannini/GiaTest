package com.giannini.ParentCast;

/**
 * Created by jiangningyu on 2017/10/5.
 */
public class Son extends Parent {

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Son() {
    }

    public Son(String school) {
        this.school = school;
    }

    public Son(Parent p) {
        super(p);
    }

    @Override
    public String toString() {
        return "Son{" +
                "school='" + school + '\'' +
                "} " + super.toString();
    }
}
