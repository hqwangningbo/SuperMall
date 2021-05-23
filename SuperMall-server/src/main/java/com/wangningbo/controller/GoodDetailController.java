package com.wangningbo.controller;

import com.wangningbo.pojo.*;
import com.wangningbo.service.GoodDetailService;
import com.wangningbo.service.GoodService;
import com.wangningbo.service.ImageService;
import com.wangningbo.service.ShopInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author wangningbo
 * @Date 2021/5/21 20:42
 */
@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodDetailController {

    private final ImageService imageService;
    private final GoodDetailService goodDetailService;
    private final ShopInfoService shopInfoService;
    private final GoodService goodService;
    @RequestMapping("/getSwiperImage")
    public List<GoodDetailImage> getSwiperImage(String iid){
        return imageService.findGoodDetailSwiperImageByIid(iid);
    }
    @RequestMapping("/getSellerShowImage")
    public List<GoodDetailImage> getSellerShowImage(String iid){
        return imageService.findGoodDetailSellerShowImageByIid(iid);
    }

    @RequestMapping("/getGoodDetail")
    public GoodDetail getGoodDetail(String iid){
        return goodDetailService.findByIid(iid);
    }
    @RequestMapping("/getShopInfo")
    public ShopInfo getShopInfo(String iid){
        return shopInfoService.findByIid(iid);
    }

    @RequestMapping("/getProductInfo")
    public List<Map> getProductInfo(String iid){
        return goodDetailService.findByProductId(iid);
    }
    @RequestMapping("/getComments")
    public List<Comment> getComments(String iid){
        return goodDetailService.findCommentByIid(iid);
    }

    @RequestMapping("/getRecommend")
    public List<Good> getRecommend(){
        int page = new Random().nextInt(5);
        return goodService.findByTypeAndPage("pop",page+1);
    }

}
