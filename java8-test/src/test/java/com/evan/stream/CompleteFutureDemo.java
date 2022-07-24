package com.evan.stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/3/2022 4:24 PM
 */
public class CompleteFutureDemo {

    public static int getMoney() throws InterruptedException {
        Thread.sleep(1_500);
        return 10;
    }

    public static BigDecimal getInterestRate() throws InterruptedException {
        Thread.sleep(1_000);
        return BigDecimal.valueOf(Double.valueOf("2.1"));
    }
    @Test
    void featureTest()  {
        ExecutorService service = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            return t;
        });
        FutureTask<Integer> moneyFuture = new FutureTask<>(()-> CompleteFutureDemo.getMoney());
        FutureTask<BigDecimal> interestFuture = new FutureTask<>(()-> CompleteFutureDemo.getInterestRate());
        service.submit(moneyFuture);
        service.submit(interestFuture);

        FutureTask<Optional<BigDecimal>> result = new FutureTask(()->{
            AtomicInteger moneyFinal = new AtomicInteger();
            Optional<BigDecimal> interest = null;
            try {
                Integer money = Optional.ofNullable(moneyFuture.get(1,TimeUnit.MINUTES)).orElse(0);
                moneyFinal.set(money);
                interest = Optional.ofNullable(interestFuture.get(1,TimeUnit.MINUTES));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if(interest.isPresent()){
                return interest.map(i->i.multiply(BigDecimal.valueOf(moneyFinal.get())));
            }
            return Optional.empty();
        });

        service.submit(result);

        try {
            System.out.println(result.get().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

    }

    @Test
    public  void completableTest() {
        ExecutorService service = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            return t;
        });

       CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()->{
            try {
                return getMoney();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
           return null;
        },service);

        CompletableFuture<BigDecimal> f2 = CompletableFuture.supplyAsync(()->{
            try {
                return getInterestRate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        },service);

        CompletableFuture<Optional<BigDecimal>> f3 = f2.thenCombineAsync(f1, (rate, money)->{
            if(rate != null){
                return Optional.ofNullable(rate.multiply(BigDecimal.valueOf(money)));
            }
            return Optional.empty();
        }, service);

        try {
            System.out.println(f3.get().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }

    @Test
    public void test(){
        Instant now = Instant.now();
        final ExecutorService service = Executors.newFixedThreadPool(24,r -> {
            Thread t = new Thread(r);
            return t;
        });
        CompletableFuture<Integer>[] futures = IntStream.range(1,100).boxed().map(i->{
            return CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.valueOf(i));
               return i;
           },service);
        }).toArray(CompletableFuture[]::new);
        List<Integer> result = Arrays.stream(futures).map(CompletableFuture::join).collect(Collectors.toList());
        long millis = Duration.between(now, Instant.now()).toMillis();
        System.out.println(millis);
    }
}
