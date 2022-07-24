package cn.kangyifan.tdd.service.impl;

import cn.kangyifan.tdd.dto.LoginDto;
import cn.kangyifan.tdd.po.User;
import cn.kangyifan.tdd.service.LoginService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author: kang Yifan
 * @Date 2022/4/13 22:05
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {


    /**
     * 做两件事
     * 1. 验证账号是否存在
     * 2. 验证密码是否正确
     * 3. 账号账号是否启用
     *
     * @param loginDto
     */
    @Override
    public void login(LoginDto loginDto) {
       String userName = loginDto.getUsername();
       User user = null;

       userDoesNotExist(user);

    }

    @Async("taskService")
    @Override
    public void asyncMethod(ServletRequestAttributes attributes)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpServletRequest request = attributes.getRequest();
        System.out.printf(Thread.currentThread().getName());
        System.out.printf(request.getRequestURI());
    }

    private void userDoesNotExist(User user) {
        if(Objects.isNull(user)) {
            throw new RuntimeException("用户名不存在");
        }
    }

}
