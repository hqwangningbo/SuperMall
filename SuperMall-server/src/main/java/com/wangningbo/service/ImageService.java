package com.wangningbo.service;

import com.wangningbo.pojo.GoodDetailImage;
import com.wangningbo.pojo.HomeImage;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 10:11
 */

public interface ImageService {
    /**
     * 查询主页轮播图
     * @return
     */
    List<HomeImage> findAllHomeSwiperImage();

    /**
     * 查询主页推荐数据
     * @return
     */
    List<HomeImage> findAllHomeRecommendImage();

    /**
     * 根据iid查询商品详情页的轮播图
     * @param iid
     * @return
     */
    List<GoodDetailImage> findGoodDetailSwiperImageByIid(String iid);

    /**
     * 根据iid查询商品详情页的卖家秀图片
     * @param iid
     * @return
     */
    List<GoodDetailImage> findGoodDetailSellerShowImageByIid(String iid);
}
