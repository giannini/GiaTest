package com.giannini.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Fenglin on 2017/5/26.
 */
public class InnerClassTest {

    public static void main(String[] args) {
        ClientSourceStatistic client = new ClientSourceStatistic();
        Statistic stat = new Statistic();
        stat.setName("hello");
        Map<String, Integer> invokeCnt = new HashMap<String, Integer>();
        invokeCnt.put("1", 50);
        invokeCnt.put("2", 60);
        invokeCnt.put("3", 80);
        stat.setInvokeCnt(invokeCnt);
        List<Statistic> statistic = new LinkedList<Statistic>();
        statistic.add(stat);
        client.setStatistic(statistic);
        client.setFrom("abc");


        System.out.println(JSON.toJSONString(client));

    }

}
