package com.wangningbo.dao;

import com.wangningbo.pojo.ProductInfo;

/**
 * @Author wangningbo
 * @Date 2021/5/22 21:12
 */

public interface ProductInfoDao {
    void insertProductInfo(ProductInfo productInfo);
    ProductInfo findByProductId(String iid);
}
