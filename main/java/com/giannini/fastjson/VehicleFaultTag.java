package com.giannini.fastjson;

import java.io.Serializable;

/**
 * Created by jiangningyu on 2017/10/16.
 */
public class VehicleFaultTag implements Serializable {

    private Integer id;

    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
