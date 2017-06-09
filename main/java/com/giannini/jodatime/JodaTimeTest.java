package com.giannini.jodatime;

import com.alibaba.fastjson.JSON;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fenglin on 2017/6/9.
 */
public class JodaTimeTest {

    public static void main(String[] args) {

        // 当天 yyyy-MM-dd
        DateTime today = DateTime.parse(DateTime.now().toString("yyyy-MM-dd")).toDateTime();
        System.out.println(today);

        //当天8点
        today = DateTime.now();
        DateTime eight = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 8, 0, 0);
        System.out.println(eight);

        //
        String day = "2017.06.09";
        today = DateTime.now();
        eight = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 8, 0, 0);
        List<String> dates = new LinkedList<String>();
        dates.add(day);
        if (today.isAfter(eight)) {
            dates.add(today.plusDays(-1).toString("yyyy.MM.dd"));
        }
        System.out.println(JSON.toJSONString(dates));

        // 昨天
        today = DateTime.now();
        DateTime yesterday = today.plusDays(-1);
        System.out.println(yesterday.toString("yyyy.MM.dd"));

    }
}
