package com.giannini.guava;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

/**
 * Created by jiangningyu on 2017/10/25.
 */
public class RangTest {

    public static void main(String[] args) {
        System.out.println(Range.downTo(50, BoundType.OPEN).contains(70));

        System.out.println(Range.downTo(50, BoundType.OPEN).contains(30));

        System.out.println(Range.upTo(20, BoundType.OPEN).contains(10));

        System.out.println(Range.upTo(20, BoundType.OPEN).contains(20));
    }
}
