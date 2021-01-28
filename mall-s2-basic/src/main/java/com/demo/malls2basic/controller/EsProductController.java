package com.demo.malls2basic.controller;

import com.demo.malls2basic.common.CommonPage;
import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.nosql.elasticsearch.document.EsProduct;
import com.demo.malls2basic.service.EsProductService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品搜索管理Controller
 * Created by Aima on 2020/12/11/15:41
 */
@Controller
@Api(tags = "EsProductController")
@RequestMapping("/esProuct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "从数据库中导入所有数据到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAll(){
        int count = esProductService.importAll();
        return  CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids){
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id){
        EsProduct esProduct = esProductService.create(id);
        if(esProduct == null){
            return CommonResult.failed();
        }
        return CommonResult.success(esProduct);
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keywords,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        Page<EsProduct> esProductPage = esProductService.search(keywords, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
}
