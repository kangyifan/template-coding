package com.evan.spi;

import java.util.ServiceLoader;


/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/11/2022 9:36 AM
 */
class MyService1Test {

    public static void main(String[] args) {
        ServiceLoader<MyService> services =  ServiceLoader.load(MyService.class);
        services.iterator().forEachRemaining(myService -> {
            myService.test();
        });
    }

}