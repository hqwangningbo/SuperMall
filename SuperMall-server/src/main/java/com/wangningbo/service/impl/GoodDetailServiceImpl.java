package com.wangningbo.service.impl;

import com.wangningbo.dao.CommentDao;
import com.wangningbo.dao.GoodDetailDao;
import com.wangningbo.dao.ProductInfoDao;
import com.wangningbo.pojo.Comment;
import com.wangningbo.pojo.GoodDetail;
import com.wangningbo.pojo.ProductInfo;
import com.wangningbo.service.GoodDetailService;
import com.wangningbo.utils.Constant;
import com.wangningbo.utils.EntityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:14
 */
@Service
@RequiredArgsConstructor
public class GoodDetailServiceImpl implements GoodDetailService {
    private final GoodDetailDao goodDetailDao;
    private final ProductInfoDao productInfoDao;
    private final CommentDao commentDao;
    @Override
    public GoodDetail findByIid(String iid) {
        return goodDetailDao.findByIid(iid);
    }

    @Override
    public List<Map> findByProductId(String productId) {
        ProductInfo productInfo = productInfoDao.findByProductId(productId);
        Map<String, Object> productInfoMap = EntityUtils.entityToMapRemoveNull(productInfo);
        productInfoMap.keySet().removeIf(key -> key.equals("productId"));
        ArrayList<Map> mapArrayList = new ArrayList<>();
        Constant constant = new Constant();
        for (String s : productInfoMap.keySet()) {
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            try {
                stringObjectHashMap.put("key", constant.getClass().getField(s).get(s));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            stringObjectHashMap.put("value",productInfoMap.get(s));
            mapArrayList.add(stringObjectHashMap);
        }
        return mapArrayList;
    }

    @Override
    public List<Comment> findCommentByIid(String iid) {
        return commentDao.findCommentByIid(iid);
    }
}
