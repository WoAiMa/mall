package com.demo.malls2basic.controller;

import com.demo.malls2basic.common.CommonPage;
import com.demo.malls2basic.common.api.CommonResult;
import com.demo.malls2basic.mbg.model.PmsBrand;
import com.demo.malls2basic.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controllr
 */
@Api(tags = "PmsBrandController")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有平抛列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("添加品跑")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("Crate PmsBrand success:{}", pmsBrand);
        }else {
            commonResult = CommonResult.failed("Operation failed");
            LOGGER.debug("Create PmsBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") long id, @RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("Update brand success: {}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("Operation failed");
            LOGGER.debug("Update brand failed: {}", pmsBrand);
        }
        return  commonResult;
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") long id){
        CommonResult commonResult;
        int count = brandService.deleteBrand(id);
        if (count == 1){
            commonResult = CommonResult.success(id);
            LOGGER.debug("Delete brand success: {}", id);
        }else {
            commonResult = CommonResult.failed("Operation failed");
            LOGGER.debug("Delete brand failed: {}", id);
        }
        return  commonResult;
    }

    @ApiOperation("品牌分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3")Integer pageSize){
        List<PmsBrand> brandList = brandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定id品牌")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> getBrand(@PathVariable("id") long id){
        return  CommonResult.success(brandService.getBrand(id));

    }

}
