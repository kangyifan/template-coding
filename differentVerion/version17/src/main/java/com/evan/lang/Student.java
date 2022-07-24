package com.evan.lang;

import com.evan.util.Timer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.net.http.HttpClient;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/4/2022 11:04 AM
 */
public class Student {

    private int a = 0;


    public static void main(String[] args)  {
        MethodType methodType = MethodType.methodType(void.class, new Class[]{Object.class, Consumer.class});

        try {
           MethodHandle handle = MethodHandles.lookup().findStatic(Timer.class, "timing", methodType);
           Consumer f = (a) -> System.out.println(a);
           handle.invoke(1, f);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(1);
    }
}
