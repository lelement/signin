package com.niull.signin.service;

import com.niull.signin.dto.Login;
import com.niull.signin.pojo.User;

/**
 * @Author niull
 * @Date 2020/10/26 20:59
 * @Description 牛立露你就写点注释吧
 */
public interface UserService {
    Integer addUser(User user);

    Login login(String account, String password);

    User getUserById(Integer id);

}
