package com.demo.malls2basic.service;

import com.demo.malls2basic.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(long id, PmsBrand pmsBrand);

    int deleteBrand(long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(long id);

}
