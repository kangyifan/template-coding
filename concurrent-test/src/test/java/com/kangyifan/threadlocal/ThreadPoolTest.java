package com.kangyifan.threadlocal;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/19 0:10
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ContextHolder.setValue(Thread.currentThread().getName());
        ExecutorService executor = Executors.newCachedThreadPool(new NamedThreadFactory("my-thread"));

        int threadTotal = ThreadLocalRandom.current().nextInt(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors()*2+1);
        CountDownLatch latch = new CountDownLatch(1);

        Thread[] threads = new Thread[threadTotal];
        for(int i = 1; i < threadTotal + 1; i++){
            Thread thread = new Thread(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String threadName = Thread.currentThread().getName();
                ContextHolder.setValue(threadName);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(50, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                executor.submit(()->{
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(50, 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("发起线程:"+threadName+",执行线程:"+Thread.currentThread().getName()+",上下文值:"+ContextHolder.getValue());
                });
            },"test"+i);
            threads[i-1] = thread;
        }

       Arrays.stream(threads).forEach(Thread::start);
       latch.countDown();
    }

    static class NamedThreadFactory implements ThreadFactory{

        private final AtomicInteger counter;

        private String name;

        public NamedThreadFactory(String name){
            this.name = name;
            this.counter = new AtomicInteger(1);

        }
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, name+"-"+counter.getAndIncrement());
            return thread;
        }
    }
}
