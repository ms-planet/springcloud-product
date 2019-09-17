package com.imooc.producter.service;

import com.imooc.producter.entity.ProductCategory;

import java.util.List;

/**
 * @author zxlei
 * @date 2019/8/21 14:03
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public interface ICategroyService {

    /**
     * 查询类目列表
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
