package cn.kangyifan.tdd.po;

import cn.kangyifan.tdd.enums.StateEnum;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 12:49
 * @Version 1.0
 */
@Data
@ToString
public class User {

    private Long id;

    private String username;

    private String password;

    private Long createUserId;

    private Date createDateTime;

    private Long modifyUserId;

    private Date modifyDateTime;

    private StateEnum state;

    private Boolean deleted;
}
