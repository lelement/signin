package com.niull.signin.service.impl;

import com.niull.signin.dto.Login;
import com.niull.signin.mapper.UserMapper;
import com.niull.signin.pojo.User;
import com.niull.signin.service.UserService;
import com.xiaoleilu.hutool.Hutool;
import com.xiaoleilu.hutool.json.JSON;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author niull
 * @Date 2020/10/26 21:00
 * @Description 牛立露你就写点注释吧
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public Integer addUser(User user) {
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public Login login(String account, String password) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("account",account)
                .andEqualTo("password",password);
        User user = userMapper.selectOneByExample(example);
        Login login = new Login();
        BeanUtils.copyProperties(user,login);
        String uuid = UUID.randomUUID().toString();
        String token = uuid + "," + user.getId();
        //将token留在redis中
        redisTemplate.opsForValue().set(token, JSONUtil.toJsonStr(user));
        redisTemplate.expire(token, 10, TimeUnit.DAYS);
        login.setToken(token);
        return login;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
