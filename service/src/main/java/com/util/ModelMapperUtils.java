package com.util;

import org.modelmapper.ModelMapper;

/**
 * @author yitiansong
 * bean转换工具类
 * 2024/5/2
 */
public class ModelMapperUtils {
    private final static ModelMapper MODEL_MAPPER = new ModelMapper();

    /**
     * Transfers model from one type to another using ModelMapper library.
     *
     * @param <P>   the type of the source model
     * @param <R>   the type of the target model
     * @param p     the source model object to transfer
     * @param clazz the class of the target model
     * @return the transferred target model object
     */
    public static <P, R> R modelTransfer(P p, Class<R> clazz) {
        return MODEL_MAPPER.map(p, clazz);
    }
}
