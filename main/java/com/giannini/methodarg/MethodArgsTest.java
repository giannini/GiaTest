package com.giannini.methodarg;

import com.alibaba.fastjson.JSON;

import java.security.Signature;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fenglin on 2017/6/21.
 */
public class MethodArgsTest {

    public static void main(String[] args) {

        Test1 total = new Test1();
        System.out.println(JSON.toJSONString(total));

        Test2 single = new Test2();
        single.setCnt(5);
        single.setYcnt(2);
        single.setNcnt(3);
        System.out.println(JSON.toJSONString(single));

        MethodArgsTest methodArgsTest = new MethodArgsTest();
        methodArgsTest.sum(total, single);
        System.out.println(JSON.toJSONString(total));

        Map<String, Test2> cache = new HashMap<String, Test2>();
        cache.put("123", single);
        System.out.println(JSON.toJSONString(cache));

        Test2 test2 = cache.get("123");
        test2.setYcnt(8);
        test2.setCnt(11);
        System.out.println(JSON.toJSONString(cache));


    }


    public void sum(Test1 total, Test2 single) {
        total.addTotalCnt(single.getCnt());
        total.addYcnt(single.getYcnt());
        total.addNcnt(single.getNcnt());
    }

}
