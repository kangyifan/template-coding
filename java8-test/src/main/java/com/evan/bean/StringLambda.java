package com.evan.bean;

import javafx.beans.binding.Bindings;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/6/2022 12:28 AM
 */
public class StringLambda {

    private static final Pattern p = Pattern.compile("a*b");

    public static void main(String[] args) {
      String a = Stream.of("123aaa","aaabbb1234acc").filter(p.asPredicate()).collect(Collectors.joining(","));
      System.out.println(a);
    }

    public static <T> Predicate<T> not(Predicate<? super T> target) {
        return  (Predicate<T>)target.negate();
    }
}
