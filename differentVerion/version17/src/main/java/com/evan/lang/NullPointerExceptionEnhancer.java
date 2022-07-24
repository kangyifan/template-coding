package com.evan.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/4/2022 11:00 AM
 */
public class NullPointerExceptionEnhancer {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static final void test1() {
        try {
            var a = new ArrayList<Integer>();
            a.add(null);
            System.out.println(a.get(0).longValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final void test2() {
        Object obj = null;
        obj.equals(null);
    }
}
