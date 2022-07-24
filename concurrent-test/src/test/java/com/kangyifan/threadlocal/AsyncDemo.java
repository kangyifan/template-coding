package com.kangyifan.threadlocal;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 6/20/2022 6:49 AM
 */
public class AsyncDemo {

    public static Integer getMoneyFromOnline(){
        System.out.println("getMoneyFromOnline undone");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getMoneyFromOnline done");
        return 100;
    }

    public static BigDecimal getInterestRateFromOnline(){
        System.out.println("getInterestRateFromOnline undone");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getInterestRateFromOnline undone");
        return new BigDecimal("0.47");
    }

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            throw new RuntimeException("1111111");
        });

        try {
            future.exceptionally(e->{
                //e.printStackTrace();
                return null;
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
