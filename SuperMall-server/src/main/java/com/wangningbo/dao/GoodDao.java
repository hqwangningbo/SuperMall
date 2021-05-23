package com.wangningbo.dao;

import com.wangningbo.pojo.Good;

import java.util.List;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/21 11:02
 */

public interface GoodDao {
    List<Good> findPopByPage(Map<String,Integer> map);
    List<Good> findNewByPage(Map<String,Integer> map);
    List<Good> findSellByPage(Map<String,Integer> map);
}
