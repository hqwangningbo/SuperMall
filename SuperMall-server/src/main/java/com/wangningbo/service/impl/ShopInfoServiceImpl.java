package com.wangningbo.service.impl;

import com.wangningbo.dao.GoodDetailDao;
import com.wangningbo.dao.ShopInfoDao;
import com.wangningbo.pojo.GoodDetail;
import com.wangningbo.pojo.ShopInfo;
import com.wangningbo.service.ShopInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:20
 */
@Service
@RequiredArgsConstructor
public class ShopInfoServiceImpl implements ShopInfoService {
    private final ShopInfoDao shopInfoDao;
    private final GoodDetailDao goodDetailDao;

    @Override
    public ShopInfo findByIid(String iid) {
        GoodDetail goodDetailDaoByIid = goodDetailDao.findByIid(iid);
        return findByShopId(goodDetailDaoByIid.getShopId());
    }

    @Override
    public ShopInfo findByShopId(String shopId) {
        return shopInfoDao.findByShopId(shopId);
    }
}
