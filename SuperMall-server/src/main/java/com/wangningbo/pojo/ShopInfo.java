package com.wangningbo.pojo;

import lombok.Data;

/**
 * @Author wangningbo
 * @Date 2021/5/22 12:53
 */
@Data
public class ShopInfo {
    /**
     * 商铺id
     */
    private String shopId;
    /**
     * 商铺名称
     */
    private String name;
    /**
     * 商铺logo地址
     */
    private String shopLogo;
    /**
     * 商铺链接
     */
    private String shopUrl;
    /**
     * 商铺总出售数量
     */
    private String cSells;
    /**
     * 商铺粉丝数
     */
    private String cFans;
    /**
     * 商铺商品种类数
     */
    private String cGoods;
    /**
     * 描述相符分数
     */
    private String descConsistentScore;
    /**
     * 价格合理分数
     */
    private String priceReasonableScore;
    /**
     * 质量满意分数
     */
    private String qualitySatisfiedScore;

}
