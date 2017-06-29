package com.giannini.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by Fenglin on 2017/6/29.
 */
public class SonResult {

    @JSONField(name = "dt_field_message")
    String message;

    Map<String, SonResult> next;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, SonResult> getNext() {
        return next;
    }

    public void setNext(Map<String, SonResult> next) {
        this.next = next;
    }
}
