package cn.kangyifan.tdd.service.impl;

import cn.kangyifan.tdd.dto.LoginDto;
import cn.kangyifan.tdd.service.LoginService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author: kang Yifan
 * @Date 2022/4/13 22:17
 * @Version 1.0
 */
@SpringBootTest(classes = LoginServiceImpl.class)
public class LoginServiceImplTest {

    @Autowired
    private LoginService loginService;


    @DisplayName("用户名不存在")
    @Test
    void givenWithoutUsernameWhenLoginThenThrowRunTimeException() {
        Assertions.assertThatThrownBy(()->{
            loginService.login(new LoginDto().setUsername("kang"));
        }).isInstanceOf(RuntimeException.class).hasMessage("用户名不存在");

    }


    @DisplayName("密码错误")
    @Test
    void givenFallaciousPasswordWhenLoginThenThrowRunTimeException() {
        Assertions.assertThatThrownBy(()->{
            loginService.login(new LoginDto().setPassword("123"));
        }).isInstanceOf(RuntimeException.class).hasMessage("密码不正确");
    }
}