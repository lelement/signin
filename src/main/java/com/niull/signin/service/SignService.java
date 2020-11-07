package com.niull.signin.service;

import com.niull.signin.pojo.Sign;

import java.util.List;

/**
 * @Author niull
 * @Date 2020/10/26 21:22
 * @Description 牛立露你就写点注释吧
 */
public interface SignService {
    Integer addSign(Sign sign);

    List<Sign> querySignRecordByUserId(Integer signId);
}
