package com.wangningbo.dao;

import com.wangningbo.pojo.ProductInfo;
import com.wangningbo.utils.EntityUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:40
 */

 class test {
    @Test
    void test(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("ii");
        productInfo.setPattern("mi");
        Map<String, Object> stringObjectMap = EntityUtils.entityToMapRemoveNull(productInfo);
        System.out.println(stringObjectMap);
        ArrayList<Map> mapList = new ArrayList<>();
        for (String s : stringObjectMap.keySet()) {
            HashMap<String, Object> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("key",s);
            stringStringHashMap.put("value",stringObjectMap.get(s));
            mapList.add(stringStringHashMap);
        }
        System.out.println(mapList);
//        mapList.add()
    }
}
