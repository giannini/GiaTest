package com.giannini.mapper;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Fenglin on 2017/5/11.
 */
public class UserDTO {

    @JSONField(name = "id")
    private long id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "age")
    private int age;

    @JSONField(name = "addr")
    private String address;

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
