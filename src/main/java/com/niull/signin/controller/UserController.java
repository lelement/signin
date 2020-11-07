package com.niull.signin.controller;

import com.niull.signin.dto.Login;
import com.niull.signin.pojo.User;
import com.niull.signin.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author niull
 * @Date 2020/10/26 20:42
 * @Description 牛立露你就写点注释吧
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Integer registerUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @GetMapping("/login")
    public Login login(@RequestParam(value = "account")@ApiParam(value = "账号",defaultValue = "c-niull") String account,
                       @RequestParam(value="password") @ApiParam(value = "密码",defaultValue = "qwe123..") String password){
        return userService.login(account,password);
    }


    @DeleteMapping("/login1")
    public Login login1(User user){
        return userService.login(user.getAccount(),user.getPassword());
    }
    @ApiOperation("通过userId获取用户信息")
    @GetMapping("/get/user/{id}")
    public User getUserById(@PathVariable("id") @ApiParam(name = "参数",value = "用户id",defaultValue = "1") Integer id){
        return userService.getUserById(id);
    }


}
