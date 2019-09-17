package com.imooc.producter.enums;

import lombok.Getter;

/**
 * @author zxlei
 * @date 2019/8/21 13:57
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),

    DOWN(1, "下架");


    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
