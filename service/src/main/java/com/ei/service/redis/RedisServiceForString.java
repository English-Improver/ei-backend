package com.ei.service.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Redis service for handling string values.
 *
 * @author yitiansong
 * @since 2024/8/11
 */
@Service
public class RedisServiceForString {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceForString.class);
    private final StringRedisTemplate stringRedisTemplate;

    public RedisServiceForString(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean setValue(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.error("Error setting value in Redis", e);
            return false;
        }
    }

    public String getValue(String key) {
        try {
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("Error getting value from Redis", e);
            return null;
        }
    }

    public boolean setHashValue(String key, String hashKey, String value) {
        try {
            stringRedisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            logger.error("Error setting hash value in Redis", e);
            return false;
        }
    }

    public String getHashValue(String key, String hashKey) {
        try {
            return (String) stringRedisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            logger.error("Error getting hash value from Redis", e);
            return null;
        }
    }

    public void setValueWithExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        try {
            stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        } catch (Exception e) {
            logger.error("Error setting value with expiration in Redis", e);
        }
    }

    public boolean delete(String key) {
        try {
            return Boolean.TRUE.equals(stringRedisTemplate.delete(key));
        } catch (Exception e) {
            logger.error("Error deleting key from Redis", e);
            return false;
        }
    }
}