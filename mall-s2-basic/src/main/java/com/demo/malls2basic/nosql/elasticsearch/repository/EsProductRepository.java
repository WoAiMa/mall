package com.demo.malls2basic.nosql.elasticsearch.repository;

import com.demo.malls2basic.nosql.elasticsearch.document.EsProduct;
import com.github.pagehelper.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * Created by Aima on 2020/12/10/18:41
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    /**
     * 搜索查询
     * @param name          商品名称
     * @param subtitle      商品标题
     * @param keywords      商品关键子
     * @param page          分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subtitle, String keywords, Pageable page);
}
