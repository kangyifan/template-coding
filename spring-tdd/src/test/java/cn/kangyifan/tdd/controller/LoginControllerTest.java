package cn.kangyifan.tdd.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONUtil;
import cn.kangyifan.tdd.dto.LoginDto;
import cn.kangyifan.tdd.service.LoginService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 11:26
 * @Version 1.0
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = LoginController.class)
@ComponentScan("cn.kangyifan.tdd")
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MockHttpSession session = new MockHttpSession();

    @MockBean
    private LoginService loginService;

    @Autowired
    private LoginController loginController;

    public static Stream<Arguments> effectiveParameter(){
        return Stream.of(Arguments.arguments(
           new LoginDto().setUsername("test").setPassword("123456")
        ));
    }

    /**
     *
     * 有效登录信息测试
     *
     */
    @DisplayName("验证正常登录")
    @Order(Order.DEFAULT)
    @ParameterizedTest
    @MethodSource("effectiveParameter")
    void givenEffectiveParamWhenLoginThenReturn(LoginDto loginDto) throws Exception {
        doNothing().when(loginService).login(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSONUtil.toJsonStr(loginDto))
                        .session(session))
                .andExpectAll(
                   MockMvcResultMatchers.status().isOk(),
                   MockMvcResultMatchers.content().string("success")
                );
    }

    public static Stream<Arguments> invalidParameter(){
        Arguments[] arguments = {
                Arguments.arguments(new LoginDto().setUsername(null).setPassword(null)),
                Arguments.arguments(new LoginDto().setUsername("kangyifan").setPassword(null)),
                Arguments.arguments(new LoginDto().setUsername(null).setPassword("123456"))
        };
        return Stream.of(arguments);
    }

    /**
     *
     * 无效登录信息测试
     *
     */
    @DisplayName("无效登录信息测试")
    @Order(Order.DEFAULT)
    @ParameterizedTest
    @MethodSource("invalidParameter")
    void givenInvalidParamWhenLoginThenReturn(LoginDto loginDto) throws Exception {
        doNothing().when(loginService).login(any());

        Throwable throwable = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSONUtil.toJsonStr(loginDto))
                        .session(session))
                .andExpectAll(
                        MockMvcResultMatchers.status().is4xxClientError()
                ).andReturn().getResolvedException();

        Assertions.assertTrue(throwable instanceof BindException, "异常类型不匹配");
    }

}