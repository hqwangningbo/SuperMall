package com.wangningbo.controller;

import com.wangningbo.pojo.Good;
import com.wangningbo.pojo.HomeImage;
import com.wangningbo.service.GoodService;
import com.wangningbo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 12:00
 */
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final ImageService imageService;
    private final GoodService goodService;

    @GetMapping("/getSwiperImage")
    public List<HomeImage> getSwiperImage(){
        return imageService.findAllHomeSwiperImage();
    }

    @GetMapping("/getRecommendImage")
    public List<HomeImage> getRecommendImage(){
        return imageService.findAllHomeRecommendImage();
    }

    @RequestMapping("/goods")
    public List<Good> getGoodList(String type, Integer page){
        return goodService.findByTypeAndPage(type,page);
    }

}
