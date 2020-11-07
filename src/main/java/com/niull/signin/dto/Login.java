package com.niull.signin.dto;

import com.niull.signin.pojo.User;
import lombok.Data;

/**
 * @Author niull
 * @Date 2020/10/26 22:14
 * @Description 牛立露你就写点注释吧
 */
@Data
public class Login extends User {
    private String token;
}
