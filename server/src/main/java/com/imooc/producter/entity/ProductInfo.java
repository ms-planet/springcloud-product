package com.imooc.producter.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxlei
 * @since 2019-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
