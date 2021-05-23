package com.wangningbo.service.impl;

import com.wangningbo.dao.ImageDao;
import com.wangningbo.pojo.GoodDetailImage;
import com.wangningbo.pojo.HomeImage;
import com.wangningbo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 12:01
 */
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageDao imageDao;

    @Override
    public List<HomeImage> findAllHomeSwiperImage() {
        return imageDao.findAllHomeSwiperImage();
    }

    @Override
    public List<HomeImage> findAllHomeRecommendImage() {
        return imageDao.findAllHomeRecommendImage();
    }

    @Override
    public List<GoodDetailImage> findGoodDetailSwiperImageByIid(String iid) {
        return imageDao.findGoodDetailSwiperImageByIid(iid);
    }

    @Override
    public List<GoodDetailImage> findGoodDetailSellerShowImageByIid(String iid) {
        return imageDao.findGoodDetailSellerShowImageByIid(iid);
    }
}
