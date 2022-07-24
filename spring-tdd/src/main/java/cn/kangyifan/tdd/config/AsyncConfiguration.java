package cn.kangyifan.tdd.config;

import cn.hutool.core.thread.NamedThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/17 22:16
 */
@EnableAsync
@Configuration
public class AsyncConfiguration {

    @Bean(value = "taskService", destroyMethod = "shutdown")
    public ExecutorService executorService(){
        ExecutorService service =  Executors.newFixedThreadPool(10, new NamedThreadFactory("My-ThreadPool",true));
        return service;
    }
}
