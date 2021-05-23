package com.wangningbo.dao;

import com.wangningbo.pojo.GoodDetail;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/22 12:18
 */

public interface GoodDetailDao {
    void insertGoodDetail(GoodDetail goodDetail);
    void updateGoodDetail(GoodDetail goodDetail);
    List<GoodDetail> findAll();
    GoodDetail findByIid(String iid);
}
