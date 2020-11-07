package com.niull.signin.controller;

import com.niull.signin.pojo.Sign;
import com.niull.signin.service.SignService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author niull
 * @Date 2020/10/26 21:21
 * @Description 牛立露你就写点注释吧
 */
@RestController
@RequestMapping(value = "/sign")
public class SignController {
    @Resource
    private SignService signService;

    @PostMapping("/user")
    public Integer signByUser(@RequestBody @ApiParam Sign sign){
            return signService.addSign(sign);
    }

    @GetMapping("/query/sign/record")
    public List<Sign> querySignRecordByUserName(@RequestParam(value = "signId") @ApiParam(value = "签到人id",defaultValue = "1") Integer signId){
        return signService.querySignRecordByUserId(signId);
    }
}
