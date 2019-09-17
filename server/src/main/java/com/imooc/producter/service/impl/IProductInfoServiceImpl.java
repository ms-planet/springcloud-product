package com.imooc.producter.service.impl;

import com.imooc.product.client.common.DecreaseStockInput;
import com.imooc.product.client.common.ProductInfoOutPut;
import com.imooc.producter.entity.ProductInfo;
import com.imooc.producter.enums.ProductStatusEnum;
import com.imooc.producter.enums.ResultEnum;
import com.imooc.producter.exception.ProductExcetion;
import com.imooc.producter.mapper.ProductInfoDAO;
import com.imooc.producter.service.IProductInfoService;
import com.imooc.producter.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zxlei
 * @date 2019/8/21 13:54
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Service
public class IProductInfoServiceImpl implements IProductInfoService {


    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDAO.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    @Override
    public List<ProductInfoOutPut> findList(List<String> productIdList) {
        return productInfoDAO.findByProductIdIn(productIdList).stream().map(e -> {
            ProductInfoOutPut outPut = new ProductInfoOutPut();
            BeanUtils.copyProperties(e, outPut);
            return outPut;
        }).collect(Collectors.toList());
    }

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        decreaseStockInputList.forEach(cart -> {
            Optional<ProductInfo> productInfoOptional = productInfoDAO.findById(cart.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductExcetion(ResultEnum.PRODUCT_NOT_EXISTS);
            }
            ProductInfo productInfo = productInfoOptional.get();
            //商品库存是否足够
            int result = productInfo.getProductStock() - cart.getProductQuantity();
            if (result < 0) {
                throw new ProductExcetion(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDAO.save(productInfo);
            productInfoList.add(productInfo);
        });
        return productInfoList;
    }

    /**
     * 发送mq消息
     *
     * @param decreaseStockInputList
     */
    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
        List<ProductInfoOutPut> productInfoOutPutList = productInfoList.stream().map(e -> {
            ProductInfoOutPut outPut = new ProductInfoOutPut();
            BeanUtils.copyProperties(e, outPut);
            return outPut;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutPutList));

    }

}
