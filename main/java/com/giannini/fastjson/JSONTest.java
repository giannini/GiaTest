package com.giannini.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Fenglin on 2017/6/23.
 */
public class JSONTest {


    public static void main(String[] args) {

        JSONTest jsonTest = new JSONTest();
        //jsonTest.test();
//        jsonTest.testParsedResult();
        jsonTest.testVehicleTag();
    }

    public void testVehicleTag() {
        List<VehicleFaultTag> tags = new LinkedList<VehicleFaultTag>();
        VehicleFaultTag tag1 = new VehicleFaultTag();
        tag1.setId(1);
        tag1.setName("1号");
        tags.add(tag1);
        VehicleFaultTag tag2 = new VehicleFaultTag();
        tag2.setId(2);
        tag2.setName("2号");
        tags.add(tag2);

        System.out.println(JSON.toJSONString(tags));

    }

    public void testParsedResult() {

        SonResult son = new SonResult();
        son.setMessage("thread");
        SonResult son1 = new SonResult();
        son1.setMessage("123");


        SonResult son2 = new SonResult();
        son2.setMessage("thread-123");
        Map<String, SonResult> map2 = new HashMap<String, SonResult>();
        map2.put("a", son);
        map2.put("b", son1);
        son2.setNext(map2);

        SonResult son3 = new SonResult();
        son3.setMessage("abc");

        ParserResult result = new ParserResult();
        result.setBaseMessage("user:abc, method:thread-123");
        Map<String, SonResult> map1 = new HashMap<String, SonResult>();
        map1.put("user", son3);
        map1.put("method", son2);
        result.setValues(map1);

        System.out.println(JSON.toJSONString(result));
    }


    public void test() {
        TestObject test = new TestObject();

        test.setField("message");
        test.setLevel(1);
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("hello", "world");
        testMap.put("age", 17);
        test.setOthers(testMap);
        System.out.println(JSON.toJSONString(testMap));
        System.out.println(JSON.toJSONString(testMap, SerializerFeature.UseSingleQuotes));
        // System.out.println(JSON.toJSONString(test));
    }

    public class TestObject {

        @JSONField(name = "field")
        private String field;

        @JSONField(name = "level")
        private int level;

        @JSONField()
        private Map<String, Object> others;

        @JSONField(name = "next")
        private List<TestObject> next;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Map<String, Object> getOthers() {
            return others;
        }

        public void setOthers(Map<String, Object> others) {
            this.others = others;
        }

        public List<TestObject> getNext() {
            return next;
        }

        public void setNext(List<TestObject> next) {
            this.next = next;
        }
    }
}
