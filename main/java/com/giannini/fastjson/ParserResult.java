package com.giannini.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by Fenglin on 2017/6/29.
 */
public class ParserResult {

    @JSONField(name = "dt_field_message")
    String baseMessage;

    @JSONField(name = "next")
    Map<String, SonResult> values;

    public String getBaseMessage() {
        return baseMessage;
    }

    public void setBaseMessage(String baseMessage) {
        this.baseMessage = baseMessage;
    }

    public Map<String, SonResult> getValues() {
        return values;
    }

    public void setValues(Map<String, SonResult> values) {
        this.values = values;
    }
}
