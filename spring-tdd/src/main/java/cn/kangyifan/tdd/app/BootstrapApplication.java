package cn.kangyifan.tdd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 11:22
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "cn.kangyifan.tdd")
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }
}
