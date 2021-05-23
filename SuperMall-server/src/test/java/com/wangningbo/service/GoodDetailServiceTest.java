package com.wangningbo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author wangningbo
 * @Date 2021/5/22 23:22
 */
@SpringBootTest
class GoodDetailServiceTest {
    @Autowired
    private GoodDetailService goodDetailService;

    @Test
    void findByProductId() {
        System.out.println(goodDetailService.findByProductId("1m70y5k").getClass());
    }
}
