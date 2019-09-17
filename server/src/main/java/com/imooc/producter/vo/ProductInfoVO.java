package com.imooc.producter.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zxlei
 * @date 2019/8/21 14:10
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Data
public class ProductInfoVO {


    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
