package com.giannini.jdk8;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jiangningyu
 * @date 2017/11/22
 */
public class CollectionTest {

    public static void main(String[] args) {
        listToList();
        listToMap();
    }

    private static void listToList() {
        // list对象，到list基本类型
        List<User> user = packageUser();
        List<String> userNames = user.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userNames));
        userNames = user.stream().map(u -> u.getName()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userNames));

        // list对象到list对象
        List<UserVO> userVO = user.stream().map(u -> {
            UserVO vo = new UserVO();
            vo.setName(u.getName());
            vo.setAge(u.getAge());
            return vo;
        }).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userVO));
    }

    private static void listToMap() {
        // list对象，到<id, 对象>的map
        List<User> user = packageUser();
        Map<Long, User> map = user.stream().collect(Collectors.toMap(u -> u.getId(), u -> u));
        System.out.println(JSON.toJSONString(map));
        map = user.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(JSON.toJSONString(map));

    }

    private static List<User> packageUser() {
        List<User> users = new LinkedList<User>();
        users.add(new User(1, "kaka", 32, "usa"));
        users.add(new User(2, "Ronaldo", 28, "port"));
        users.add(new User(3, "xixi", 26, "aga"));
        return users;
    }
}
