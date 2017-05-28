package com.giannini.fastjson;

import java.util.Map;

/**
 * Created by Fenglin on 2017/5/26.
 */
public class Statistic {


    private String name;

    private Map<String, Integer> invokeCnt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getInvokeCnt() {
        return invokeCnt;
    }

    public void setInvokeCnt(Map<String, Integer> invokeCnt) {
        this.invokeCnt = invokeCnt;
    }
}
