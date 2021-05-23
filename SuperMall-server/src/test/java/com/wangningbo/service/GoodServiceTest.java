package com.wangningbo.service;

import com.wangningbo.pojo.Good;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:58
 */
@SpringBootTest
class GoodServiceTest {
    @Autowired
    private GoodService service;
    @Test
    void findByTypeAndPage(){
        System.out.println(service.findByTypeAndPage("pop", 1));
    }
    @Test
    void getRecommend(){
        int page = new Random().nextInt(10);
        System.out.println(page);
        for (Good pop : service.findByTypeAndPage("pop", page+1)) {
            System.out.println(pop);
        }
    }

}
