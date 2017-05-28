package com.giannini.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Map;

/**
 * Created by Fenglin on 2017/5/26.
 */
public class ClientSourceStatistic {

    @JSONField(name = "from")
    private String from;

    @JSONField(name = "statistic")
    private List<Statistic> statistic;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<Statistic> getStatistic() {
        return statistic;
    }

    public void setStatistic(List<Statistic> statistic) {
        this.statistic = statistic;
    }

}
