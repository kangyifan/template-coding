package cn.kangyifan.tdd.controller;

import cn.kangyifan.tdd.dto.LoginDto;
import cn.kangyifan.tdd.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 11:26
 * @Version 1.0
 */
@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody  LoginDto loginDto) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        loginService.asyncMethod(attributes);
        return "success";
    }

}
