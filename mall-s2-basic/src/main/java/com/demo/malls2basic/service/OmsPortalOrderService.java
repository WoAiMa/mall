package com.demo.malls2basic.service;

import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aima on 2021/01/21/14:49
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     * @param orderParam
     * @return
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);

}
