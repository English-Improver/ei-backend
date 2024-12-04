package com.ei.service;

import com.ei.constant.RedisKey;
import com.ei.constant.UrlParamsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.stream.Stream;

import static com.ei.constant.RedisKey.URL_PARTS;

/**
 * @author yitiansong
 * @since 11/5/24
 */

public class InterfacePlafromServiceImpl implements InterfacePlatformService {
    private static volatile String[] parts = new String[UrlParamsEnum.values().length];
    private static volatile Object[] locks = new Object[UrlParamsEnum.values().length];

    private final StringRedisTemplate stringRedisTemplate;

    public InterfacePlafromServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public String getUrl(UrlParamsEnum platform, UrlParamsEnum appCode, String esType) {
        String part0 = getParts(platform);
        String part1 = getParts(appCode);
        return part0 + part1 + esType;
    }

    /**
     * url 结构： ip_part;app_part; service_part(不用在redis中拿)
     * 根据urlParams获取codeType从redis中拿去数据
     * @param urlParams 拼接url的参数
     * @return 返回该部分的值
     */
    private String getParts(UrlParamsEnum urlParams) {
        String key = RedisKey.generate(RedisKey.URL_PARTS, urlParams.getCodeType());
        int index = urlParams.ordinal();
        String part = stringRedisTemplate.opsForValue().get(key);
        if (part == null) {
            synchronized(locks[index]) {
                String partInRedis = stringRedisTemplate.opsForValue().get(key);
                if (partInRedis != null) {
                    return partInRedis;
                }
                // get from db
                String partInDB = "";
                part = partInDB;
                stringRedisTemplate.opsForValue().set(key, partInDB);
            }

        }
        return part;
    }
    public static void main(String[] args) {
        System.out.println(UrlParamsEnum.USER_CENTER_PLATFORM.ordinal());
        Stream.of(UrlParamsEnum.values()).forEach(System.out::println);
    }
}
