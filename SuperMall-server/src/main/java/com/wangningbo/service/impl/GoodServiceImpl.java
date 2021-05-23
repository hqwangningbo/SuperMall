package com.wangningbo.service.impl;

import com.wangningbo.dao.GoodDao;
import com.wangningbo.pojo.Good;
import com.wangningbo.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/21 19:59
 */
@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {
    private final GoodDao goodDao;
    @Override
    public List<Good> findByTypeAndPage(String type, Integer page) {
        List<Good> goods = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",(page-1)*30);
        map.put("pageSize",30);
        switch (type){
            case "pop":
                goods = goodDao.findPopByPage(map);
                break;
            case "new":
                goods = goodDao.findNewByPage(map);
                break;
            case "sell":
                goods = goodDao.findSellByPage(map);
                break;
            default:
                break;
        }
        return goods;
    }
}
