package com.niull.signin.service.impl;

import com.niull.signin.mapper.SignMapper;
import com.niull.signin.pojo.Sign;
import com.niull.signin.service.SignService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author niull
 * @Date 2020/10/26 21:22
 * @Description 牛立露你就写点注释吧
 */
@Service
public class SignServiceImpl implements SignService {
    @Resource
    private SignMapper signMapper;


    @Override
    public Integer addSign(Sign sign) {
        sign.setSignTime(new Date());
        return signMapper.insert(sign);
    }

    @Override
    public List<Sign> querySignRecordByUserId(Integer signId){
        Example example = new Example(Sign.class);
        example.createCriteria()
                .andEqualTo("signId",signId);
        return signMapper.selectByExample(example);
    }
}
