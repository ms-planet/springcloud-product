package com.imooc.producter;

import com.imooc.producter.entity.ProductCategory;
import com.imooc.producter.entity.ProductInfo;
import com.imooc.producter.mapper.ProductCategoryDAO;
import com.imooc.producter.mapper.ProductInfoDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxlei
 * @date 2019/8/21 11:45
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoTest {

    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Test
    public void testfindByProductStatus() {
        List<ProductInfo> list = productInfoDAO.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testfindByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryDAO.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testfindByProductIdIn() {
        List<ProductInfo> productInfoList = productInfoDAO.findByProductIdIn(Arrays.asList("164103465734242707"));
        Assert.assertTrue(productInfoList.size() > 0);
        System.out.println(productInfoList);
    }


}
