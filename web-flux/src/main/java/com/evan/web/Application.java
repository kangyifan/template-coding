package com.evan.web;

import com.evan.web.processor.InstanceBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/11/2022 3:01 PM
 */
@EnableWebFlux
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
