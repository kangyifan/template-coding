package com.kangyifan.threadlocal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/18 22:44
 */
class ContextHolderTest {

    private  static Thread t;


    public static void main(String[] args) throws InterruptedException {
        t = new Thread(() -> {
            ContextHolder.setValue("1");
            String a = ContextHolder.getValue();
            System.out.println(Thread.currentThread()+":"+ a);
            new MyThread(t,"test",()->{
                System.out.println(Thread.currentThread()+":"+ ContextHolder.getValue());
            }).start();

        },"test");
        //t.setDaemon(true);
        t.start();
        Thread.sleep(5000); // 5s后主线程退出
        System.out.println("结束");
        System.out.println(t.isAlive());
    }

    @FunctionalInterface
    interface PostProcessor{
        void process();
    }

    static class MyThread extends Thread{

        private Thread parent;

        private PostProcessor processor;

        public MyThread(Thread parent, String name,PostProcessor processor){
            super(parent.getName()+"-"+name);
            this.parent = parent;
            this.processor = processor;
        }

        @Override
        public void run() {
            String a = ContextHolder.getValue();
            System.out.println(Thread.currentThread()+":"+ a);
            processor.process();
        }
    }
}