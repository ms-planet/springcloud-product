package com.imooc.product.client.common;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author zxlei
 * @date 2019/8/26 14:25
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Data
public class ProductInfoOutPut implements Serializable {

    private static final long serialVersionUID = 5278948095174725717L;


    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;


}
