package com.evan.demo.j9;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/3/2022 8:15 PM
 */
public class MyServiceImpl implements MyService {
    public static void main(String[] args) {
        MyService myService = new MyServiceImpl();
        System.out.println(myService.addEvenNumbers(1,2,3));
    }
}
