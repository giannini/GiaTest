package com.giannini.ParentCast;

/**
 * Created by jiangningyu on 2017/10/5.
 */
public class CastTest {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.setAge(89);
        p.setName("jack");
        System.out.println("parent: " + p.toString());

        Son s = new Son(p);
        System.out.println("son: " + s.toString());


    }
}
