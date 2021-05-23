package com.wangningbo.pojo;

import lombok.Data;

/**
 * @Author wangningbo
 * @Date 2021/5/21 21:21
 */
@Data
public class GoodDetail{

    /**
     * 唯一id
     */
    private String iid;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品描述
     */
    private String desc;
    /**
     * 原始价格
     */
    private String oldPrice;
    /**
     * 现在价格，可能是个价格区间
     */
    private String price;
    /**
     * 折扣描述
     */
    private String discountDesc;
    /**
     * 销售量
     */
    private String sales;
    /**
     * 收藏数
     */
    private String collections;
    /**
     * 发货方式
     */
    private String deliveryMethod;
    /**
     * 商铺id
     */
    private String shopId;
}
