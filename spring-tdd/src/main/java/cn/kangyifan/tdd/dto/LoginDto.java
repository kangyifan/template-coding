package cn.kangyifan.tdd.dto;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: kang Yifan
 * @Date 2022/4/12 11:35
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class LoginDto implements Serializable {

    @NotBlank(message = "用户名称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
