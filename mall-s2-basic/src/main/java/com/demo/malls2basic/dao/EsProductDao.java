package com.demo.malls2basic.dao;

import com.demo.malls2basic.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Aima on 2020/12/10/18:59
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id")Long id);
}
