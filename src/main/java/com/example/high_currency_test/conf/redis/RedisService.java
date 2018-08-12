package com.example.high_currency_test.conf.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作工具类
 *
 * @author ZhangGR
 * @created on 2018/8/10
 **/
@Slf4j
@Service
public class RedisService {

        @Autowired
        private RedisTemplate redisTemplate;

        /**
         * 写入缓存（设置过期时间）
         * @param key
         * @param value
         * @return
         */
        public boolean set(String key, Object value, long timeout) {
            boolean result = false;
            try{
                final ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
                valueOperations.set(key, value);
                redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            } catch (Exception e) {
                result = false;
                log.error("error occurred during opsForValue:", e);
            }

            return result;
        }

        /**
         * 写入缓存（不设置过期时间）
         * @param key
         * @param value
         * @return
         */
        public boolean set(String key, Object value) {

            boolean result = false;
            try{
               final ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
               valueOperations.set(key, value);
            } catch (Exception e) {
               result = false;
               log.error("error occurred during opsForValue:", e);
            }

            return result;
        }

}
