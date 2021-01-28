package com.demo.malls2basic.dto;

import lombok.Data;

/**
 * Created by Aima on 2021/01/21/14:52
 */
@Data
public class OrderParam {
    /**
     * 收货地址ID
     */
    private Long memberReceiveAddressId;
    /**
     * 优惠券ID
     */
    private Long couponId;
    /**
     * 使用积分数
     */
    private Integer useIntegration;
    /**
     * 支付类型
     */
    private Integer payType;


}
