package com.wangningbo.pojo;

import lombok.Data;

/**
 * @Author wangningbo
 * @Date 2021/5/22 20:53
 */
@Data
public class ProductInfo {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 图案
     */
    private String pattern;
    /**
     * 厚薄
     */
    private String thickAndThin;
    /**
     * 厂名
     */
    private String factoryName;
    /**
     * 厂址
     */
    private String factoryAddress;
    /**
     * 颜色
     */
    private String color;
    /**
     * 季节
     */
    private String season;
    /**
     * 材质
     */
    private String material;
    /**
     * 领型
     */
    private String collarType;
    /**
     * 库型
     */
    private String pantsType;
    /**
     * 袖长
     */
    private String sleeveLength;
    /**
     * 衣长
     */
    private String clothingLength;
    /**
     * 裤长
     */
    private String pantsLength;
    /**
     * 风格
     */
    private String style;
    /**
     * 款式
     */
    private String styleForm;
    /**
     * 尺码
     */
    private String size;
}
