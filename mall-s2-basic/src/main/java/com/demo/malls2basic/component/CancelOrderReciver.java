package com.demo.malls2basic.component;

import com.demo.malls2basic.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息处理者
 * Created by Aima on 2021/01/21/12:31
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReciver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReciver.class);
    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("Reciver delay message orderId: {}", orderId);
        omsPortalOrderService.cancelOrder(orderId);
    }
}
