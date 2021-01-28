package com.demo.malls2basic.controller;

import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.dto.OrderParam;
import com.demo.malls2basic.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理
 * Created by Aima on 2021/01/21/15:13
 */
@Controller
@Api(tags = "OmsPortalOrderController")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @ApiOperation("生成订单")
    @RequestMapping(value = "/genetorOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam){
        return omsPortalOrderService.generateOrder(orderParam);
    }
}
