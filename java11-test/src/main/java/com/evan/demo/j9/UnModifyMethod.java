package com.evan.demo.j9;

import java.util.List;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/3/2022 8:45 PM
 */
public class UnModifyMethod {
    public static void main(String[] args) {
      List<Integer> integers =  List.of(1,2,3,4);
        Stream.ofNullable(3).map(a-> 2).forEach(System.out::println);
    }
}
