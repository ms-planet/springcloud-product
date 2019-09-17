package com.imooc.producter.mapper;

import com.imooc.producter.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxlei
 * @since 2019-08-21
 */
public interface ProductInfoDAO extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);


    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
