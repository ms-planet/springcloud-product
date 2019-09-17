package com.imooc.producter.service;

import com.imooc.product.client.common.DecreaseStockInput;
import com.imooc.product.client.common.ProductInfoOutPut;
import com.imooc.producter.entity.ProductInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxlei
 * @since 2019-08-21
 */
public interface IProductInfoService {

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();


    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfoOutPut> findList(List<String> productIdList);


    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     * @return
     */
    List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList);

    /**
     * 发送mq消息
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
