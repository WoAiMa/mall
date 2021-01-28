package com.demo.malls2basic.service.impl;

import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.component.CancelOrderSender;
import com.demo.malls2basic.dto.OrderParam;
import com.demo.malls2basic.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aima on 2021/01/21/14:57
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // TODO 执行下单操作
        LOGGER.info("Starting generate order");
        // 下单完成后生成一个延时消息，用于取消超时订单
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");
    }

    /**
     * 发送延迟消息
     * @param orderId
     */
    private void sendDelayMessageCancelOrder(long orderId) {
        long delayTimes = 30 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("Cancel order...orderId: {}", orderId);
    }
}
