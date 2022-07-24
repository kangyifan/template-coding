package cn.kangyifan.tdd.service;

import cn.kangyifan.tdd.dto.LoginDto;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.Future;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 13:12
 * @Version 1.0
 */
public interface LoginService {

    /**
     * 登录逻辑的接口
     *
     * @param loginDto
     *
     */
    void login(LoginDto loginDto);

    /**
     * 异步方法
     * @return
     */
    void asyncMethod(ServletRequestAttributes attributes);
}
