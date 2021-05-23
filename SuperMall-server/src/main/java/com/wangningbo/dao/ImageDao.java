package com.wangningbo.dao;

import com.wangningbo.pojo.GoodDetailImage;
import com.wangningbo.pojo.HomeImage;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 10:11
 */

public interface ImageDao {
    List<HomeImage> findAllHomeSwiperImage();
    List<HomeImage> findAllHomeRecommendImage();
    List<GoodDetailImage> findGoodDetailSwiperImageByIid(String iid);
    List<GoodDetailImage> findGoodDetailSellerShowImageByIid(String iid);
}
