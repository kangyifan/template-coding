package com.kangyifan.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/18 22:39
 */
public class ContextHolder {

    private static TransmittableThreadLocal<String> childLocal = new TransmittableThreadLocal<>();

    public static void setValue(String value){
        childLocal.set(value);
    }

    public static String getValue(){
        return childLocal.get();
    }


}
