package com.demo.malls2basic.service.impl;

import com.demo.malls2basic.dao.EsProductDao;
import com.demo.malls2basic.nosql.elasticsearch.document.EsProduct;
import com.demo.malls2basic.nosql.elasticsearch.repository.EsProductRepository;
import com.demo.malls2basic.service.EsProductService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 商品搜索管理色弱vice实现类
 * Created by Aima on 2020/12/10/18:58
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductDao esProductDao;
    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = esProductRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int count = 0;
        while (iterator.hasNext()){
            count++;
            iterator.next();
        }
        return count;
    }

    @Override
    public void delete(Long id) {
        esProductRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct esProductResult = null;
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(id);
        if(esProductList != null && esProductList.size() > 0){
            EsProduct esProduct = esProductList.get(0);
            esProductResult = esProductRepository.save(esProduct);
        }
        return esProductResult;
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            EsProduct esProduct = null;
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id:
                 ids) {
                 esProduct = new EsProduct();
                 esProduct.setId(id);
                 esProductList.add(esProduct);
            }
            esProductRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keywords, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeywords(keywords, keywords, keywords, pageable);
    }
}
