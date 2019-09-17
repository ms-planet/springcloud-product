package com.imooc.producter.controller;

import com.imooc.product.client.common.DecreaseStockInput;
import com.imooc.product.client.common.ProductInfoOutPut;
import com.imooc.producter.entity.ProductCategory;
import com.imooc.producter.entity.ProductInfo;
import com.imooc.producter.service.ICategroyService;
import com.imooc.producter.service.IProductInfoService;
import com.imooc.producter.utils.ResultVOUtil;
import com.imooc.producter.vo.ProductInfoVO;
import com.imooc.producter.vo.ProductVO;
import com.imooc.producter.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxlei
 * @date 2019/8/21 11:16
 * ----------------------------------------------
 * 商品
 * ----------------------------------------------
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private ICategroyService categroyService;

    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("list")
    public ResultVO<ProductVO> list() {
        //1.查询所有在架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.查询类目
        List<ProductCategory> categoryList = categroyService.findByCategoryTypeIn(categoryTypeList);
        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        categoryList.forEach(x -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(x.getCategoryName());
            productVO.setCategoryType(x.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productInfoList.forEach(y -> {
                if (y.getCategoryType().equals(x.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(y, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            });
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        });
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutPut> ListForOrder(@RequestBody List<String> productIdList) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productInfoService.findList(productIdList);
    }


    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
         productInfoService.decreaseStock(decreaseStockInputList);
    }

}
