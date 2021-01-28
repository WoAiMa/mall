package com.demo.malls2basic.service;

import com.demo.malls2basic.nosql.elasticsearch.document.EsProduct;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 商品搜索管理
 * Created by Aima on 2020/12/10/18:51
 */
public interface EsProductService {

    /**
     * 从数据库中导入所有数据到ES
     * @return
     */
    int importAll();
    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);
    /**
     *  根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 根据id批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键子搜索名称或者副标题
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keywords, Integer pageNum, Integer pageSize);
}
