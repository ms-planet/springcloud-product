package com.imooc.producter.mapper;

import com.imooc.producter.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zxlei
 * @date 2019/8/21 12:00
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer> {

    /**
     * 查询类目列表
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
