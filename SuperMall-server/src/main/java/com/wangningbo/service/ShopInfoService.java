package com.wangningbo.service;

import com.wangningbo.pojo.ShopInfo;

/**
 * @Author wangningbo
 * @Date 2021/5/22 12:53
 */

public interface ShopInfoService {
    /**
     * 根据shopId查询商铺信息
     * @param shopId
     * @return
     */
    ShopInfo findByShopId(String shopId);

    /**
     * 根据商品iid查询商铺信息
     * @param iid
     * @return
     */
    ShopInfo findByIid(String iid);
}
