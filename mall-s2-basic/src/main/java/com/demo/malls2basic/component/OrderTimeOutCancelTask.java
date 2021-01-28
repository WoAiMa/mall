package com.demo.malls2basic.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 订单超时自动取消
 * Created by Aima on 2020/11/25/16:19
 */
@Component
public class OrderTimeOutCancelTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * 每10分钟扫描一次
     * cron表达式： seconds minutes hour dayofmonyh month dayofweek
     */
    @Scheduled(cron = "* 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        LOGGER.info("Every 10 monutes to cancal timeout order");
    }
}
