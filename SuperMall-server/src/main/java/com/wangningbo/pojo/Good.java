package com.wangningbo.pojo;

import lombok.Data;

/**
 * @Author wangningbo
 * @Date 2021/5/21 11:00
 */
@Data
public class Good {
    private String iid;
    private String title;
    private String image;
    private String price;
    /**
     * 收藏数
     */
    private String nfc;
}
