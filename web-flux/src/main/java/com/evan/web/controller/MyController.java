package com.evan.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/11/2022 3:00 PM
 */
@RestController
@RequestMapping("/test")
public class MyController {

   private static final ExecutorService service = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors(),
            2, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    @RequestMapping("/getName")
    public Mono<String> getName(){
        return Mono.just("yes").map(w->{
            System.out.println(Thread.currentThread().getName());
            return w;
        });
    }

    @RequestMapping("/getUserNames")
    public Flux<String> getUserNames(){
        return Flux.just("a","b","c","d","e","f","j","h","i","j")
                .publishOn(Schedulers.fromExecutorService(service,"myService")).map(w->{
            System.out.println(Thread.currentThread().getName());
            return w;
        });
    }
}
