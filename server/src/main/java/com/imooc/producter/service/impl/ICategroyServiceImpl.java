package com.imooc.producter.service.impl;

import com.imooc.producter.entity.ProductCategory;
import com.imooc.producter.mapper.ProductCategoryDAO;
import com.imooc.producter.service.ICategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxlei
 * @date 2019/8/21 14:04
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Service
public class ICategroyServiceImpl implements ICategroyService {


    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    /**
     * 查询类目列表
     *
     * @param categoryTypeList
     * @return
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDAO.findByCategoryTypeIn(categoryTypeList);
    }
}
