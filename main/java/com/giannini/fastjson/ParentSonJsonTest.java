package com.giannini.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jiangningyu on 2017/10/30.
 */
public class ParentSonJsonTest {

    public static void main(String[] args) {
        B b = new B();

        b.setAstr("aaaa");
        b.setBstr("bbbb");

        // 只想序列化子类的属性值
        SerializeFilter filter = new PropertyFilter() {
            @Override
            public boolean apply(Object source, String name, Object value) {
                Set<String> fields = Arrays.asList(A.class.getDeclaredFields())
                        .stream().map(f -> f.getName()).collect(Collectors.toSet());
                if (fields.contains(name)) {
                    return false;
                }
                return true;
            }
        };
        System.out.println(JSON.toJSONString(b, filter));

    }
}
