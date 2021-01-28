package com.demo.malls2basic.service.impl;

import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.service.RedisService;
import com.demo.malls2basic.service.UmsMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String PREFIX;
    @Value("${redis.key.expire.authCode}")
    private long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        LOGGER.info("Telephone is： {}", telephone);
        Random random = new Random();
        int rand = random.nextInt(100000);
        redisService.set(PREFIX+telephone, Integer.toString(rand));
        LOGGER.info("Redis key: {}, value:{}", PREFIX+telephone, rand);
        redisService.expire(PREFIX+telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(Integer.toString(rand),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        LOGGER.info("Telephone:{}, authCode: {}", telephone, authCode);
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");        }

        String realAuthCode = redisService.get(PREFIX+telephone);
        LOGGER.info("Redis key: {}", PREFIX+telephone);
        LOGGER.info("AuthCode in redis: {}", realAuthCode);
        if(authCode.equals(realAuthCode)){
            return CommonResult.success(null, "验证码校验成功");
        }else {
            return CommonResult.failed("验证码校验失败");
        }
    }
}
