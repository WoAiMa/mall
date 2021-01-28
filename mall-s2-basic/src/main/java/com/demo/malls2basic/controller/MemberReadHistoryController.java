package com.demo.malls2basic.controller;

import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.nosql.mongodb.document.MemberReadHistory;
import com.demo.malls2basic.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Aima on 2020/12/17/17:47
 */
@Controller
@Api(tags = "MemberReadHistoryController")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("生成浏览记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count = memberReadHistoryService.craate(memberReadHistory);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("珊瑚浏览记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
     public CommonResult delete(@RequestParam("ids")List<String> ids){
         int count = memberReadHistoryService.delete(ids);
         if(count > 0){
             return CommonResult.success(count);
         }
         return CommonResult.failed();
     }

     @ApiOperation("查询浏览记录")
     @RequestMapping(value = "/list", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult<List<MemberReadHistory>> list(Long memberId){
         List<MemberReadHistory> memberReadHistortList = memberReadHistoryService.list(memberId);
         return CommonResult.success(memberReadHistortList);
     }
}
