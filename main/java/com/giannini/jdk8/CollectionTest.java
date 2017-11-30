package com.giannini.jdk8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

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
        groupByMap();
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

    private static void groupByMap() {
        List<Book> books = packageBook();

        // 根据字段分类
        Map<String, List<Book>> booksGroup = books.stream().collect(Collectors.groupingBy(Book::getPublisher));
        System.out.println(JSON.toJSONString(booksGroup));

        // 比较分类
        Map<String, List<Book>> booksGroup2 = books.stream().collect(Collectors.groupingBy(book -> {
            if (book.getPrice() > 50.0) {
                return "大于50";
            } else if (book.getPrice() < 20) {
                return "小于20";
            } else {
                return "大于20，小于50";
            }
        }));
        System.out.println(JSON.toJSONString(booksGroup2));

    }

    private static List<User> packageUser() {
        List<User> users = new LinkedList<User>();
        users.add(new User(1, "kaka", 32, "usa"));
        users.add(new User(2, "Ronaldo", 28, "port"));
        users.add(new User(3, "xixi", 26, "aga"));
        return users;
    }

    private static List<Book> packageBook() {
        List<Book> books = Lists.newLinkedList();
        books.add(new Book(1L, "Java", "清华出版社", 20.34));
        books.add(new Book(2L, "C++", "清华出版社", 50.34));
        books.add(new Book(3L, "Python", "人民出版社", 12.33));
        books.add(new Book(4L, "JavaScript", "人民出版社", 35.23));
        books.add(new Book(5L, "C#", "人民出版社", 88.88));
        return books;
    }
}
