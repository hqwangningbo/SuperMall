package com.wangningbo.pojo;

import lombok.Data;

/**
 * @Author wangningbo
 * @Date 2021/5/22 20:21
 */
@Data
public class Comment {
    /**
     * 评论id
     */
    private String commentId;
    /**
     * 评论人用户名
     */
    private String uname;
    /**
     * 评论人头像地址
     */
    private String avatar;
    /**
     * 创建时间
     */
    private String created;
    /**
     * 评论人买的风格
     */
    private String style;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 商品id
     */
    private String goodId;
}
