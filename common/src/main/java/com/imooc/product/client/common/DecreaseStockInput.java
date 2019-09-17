package com.imooc.product.client.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zxlei
 * @date 2019/8/26 14:39
 * ----------------------------------------------
 * 减库存入参
 * ----------------------------------------------
 */
@Data
@AllArgsConstructor
public class DecreaseStockInput implements Serializable {

    private static final long serialVersionUID = 2917181627615779733L;

    /**
     * 商品id
     */
    private String productId;


    /**
     * 商品数量
     */
    private Integer productQuantity;
}
