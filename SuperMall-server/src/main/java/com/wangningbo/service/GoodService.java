package com.wangningbo.service;

import com.wangningbo.pojo.Good;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 12:14
 */

public interface GoodService {
    /**
     * 根据type和page查找三十条商品概况
     * @param type 商品类型
     * @param page 商品的页数
     * @return 30条商品概况
     */
    List<Good> findByTypeAndPage(String type,Integer page);
}
