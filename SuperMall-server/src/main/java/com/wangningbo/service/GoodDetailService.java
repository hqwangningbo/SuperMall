package com.wangningbo.service;

import com.wangningbo.pojo.Comment;
import com.wangningbo.pojo.GoodDetail;

import java.util.List;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:13
 */

public interface GoodDetailService {

    /**
     * 根据iid查找商品详情信息
     * @param iid
     * @return 商品详情
     */
    GoodDetail findByIid(String iid);

    /**
     * 根据iid查找产品参数并去掉为null的字段
     * @param iid
     * @return map
     */
    List<Map> findByProductId(String iid);

    /**
     *根据iid查询该商品的评论信息
     * @param iid
     * @return
     */
    List<Comment> findCommentByIid(String iid);

}
