package com.giannini.ParentCast;

/**
 * Created by jiangningyu on 2017/10/5.
 */
public class Parent {

    private String name;

    private Integer age;

    public Parent() {
    }

    public Parent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Parent(Parent p) {
        this.age = p.getAge();
        this.name = p.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
