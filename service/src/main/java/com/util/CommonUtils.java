package com.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author yitiansong
 * 通用工具类
 * 2024/5/2
 */
public class CommonUtils {

    /**
     * 判断给定的类型是否为空
     * 对于字符串、collection、map;会调用其isEmpty进行额外判断
     * @param t 需要校验的对象
     * @return boolean
     * @param <T> 任意类型
     */
    public static <T> boolean isNotEmpty(T t) {
        switch (t) {

            //
            case String s -> {
                return !s.isEmpty();
            }

            // collection
            case Collection<?> collection -> {
                return !collection.isEmpty();
            }

            // map
            case Map<?, ?> map -> {
                return !map.isEmpty();
            }
            case null, default -> {
                return false;
            }
        }

    }
}
