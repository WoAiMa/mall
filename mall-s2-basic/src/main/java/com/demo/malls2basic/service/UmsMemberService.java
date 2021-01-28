package com.demo.malls2basic.service;

import com.demo.malls2basic.common.api.CommonResult;

/**
 * 会员管理
 */
public interface UmsMemberService {

    /**
     * 获取验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 校验验证码
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
