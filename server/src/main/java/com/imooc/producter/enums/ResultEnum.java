package com.imooc.producter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zxlei
 * @date 2019/8/21 17:36
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    PRODUCT_NOT_EXISTS(121, "商品不存在"),

    PRODUCT_STOCK_ERROR(123, "库存有误")


    ;


    private int code;

    private String message;


}
