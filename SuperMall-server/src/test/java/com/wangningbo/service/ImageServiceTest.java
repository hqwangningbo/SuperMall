package com.wangningbo.service;

import com.wangningbo.pojo.GoodDetailImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/22 23:09
 */
@SpringBootTest
class ImageServiceTest {
@Autowired
private ImageService imageService;
    @Test
    void findGoodDetailSwiperImageByIid() {
        List<GoodDetailImage> goodDetailSwiperImageByIid = imageService.findGoodDetailSwiperImageByIid("1m70y5k");
        for (GoodDetailImage goodDetailImage : goodDetailSwiperImageByIid) {
            System.out.println(goodDetailImage);
        }
    }

    @Test
    void findGoodDetailSellerShowImageByIid() {
        for (GoodDetailImage goodDetailImage : imageService.findGoodDetailSellerShowImageByIid("1m70y5k")) {
            System.out.println(goodDetailImage);

        }
    }
}
