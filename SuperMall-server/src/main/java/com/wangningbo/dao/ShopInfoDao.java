package com.wangningbo.dao;

import com.wangningbo.pojo.ShopInfo;

/**
 * @Author wangningbo
 * @Date 2021/5/22 12:53
 */

public interface ShopInfoDao {
    void insertShopInfo(ShopInfo shopInfo);
    ShopInfo findByShopId(String shopId);
}
