package com.imooc.product.client;

import com.imooc.product.client.common.DecreaseStockInput;
import com.imooc.product.client.common.ProductInfoOutPut;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zxlei
 * @date 2019/8/26 15:08
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@FeignClient(name = "product",fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("product/listForOrder")
    List<ProductInfoOutPut> ListForOrder(@RequestBody List<String> productIdList);


    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);


    @GetMapping("/msg")
    String productMsg();

    @Component
    class ProductClientFallback implements ProductClient{

        /**
         * 获取商品列表(给订单服务用的)
         *
         * @param productIdList
         * @return
         */
        @Override
        public List<ProductInfoOutPut> ListForOrder(List<String> productIdList) {
            return null;
        }

        /**
         * 扣库存
         *
         * @param decreaseStockInputList
         */
        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }

        @Override
        public String productMsg() {
            return null;
        }
    }

}
