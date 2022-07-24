package com.bayss.common.netty.proto;

import static com.bayss.common.netty.proto.ProtoMessgae.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 6/28/2022 10:20 AM
 */
class CUserLoginTest {

    public static void main(String[] args) {
        CUserLogin.CUserLoginReq loginReq = CUserLogin.CUserLoginReq.newBuilder()
                .setUsername("kangyifan")
                .setPasswd("123456").build();
        byte[] messgae = loginReq.toByteArray();
        MessageeHeader header = MessageeHeader.newBuilder()
                .setCmd(1)
                .setMagicNum(16)
                .setVersion(1)
                .setLen(messgae.length)
                .build();
    }

}