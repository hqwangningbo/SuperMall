package com.wangningbo.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/22 22:35
 */

public class EntityUtils {
    /**
     * 实体类转Map
     * @param object
     * @return
     */
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> map = new HashMap();
        for (Field field : object.getClass().getDeclaredFields()){
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                map.put(field.getName(), o);
                field.setAccessible(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    /**
     * 实体类转Map,去掉值为null的值
     * @param object
     * @return
     */
    public static Map<String, Object> entityToMapRemoveNull(Object object) {
        Map<String, Object> map = new HashMap();
        for (Field field : object.getClass().getDeclaredFields()){
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                if (o != null) {
                    map.put(field.getName(), o);
                    field.setAccessible(flag);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
