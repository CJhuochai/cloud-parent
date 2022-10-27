package cloud.server.common.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
public class RedisUtil {

    private static RedisTemplate<String,Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    public static void set(String key, Object valuet) {
        set(key, valuet, null,null);
    }

    public static void set(String key, Object value, Long timeOut, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value);
        if (null != timeOut)
            redisTemplate.expire(key, timeOut, timeUnit);
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    public static void setList(String key, List<Object> values, Long timeOut) {
        values.forEach(value -> redisTemplate.opsForList().leftPush(key, value));
        redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
    }

    public static boolean hasKey(String key){
        return StrUtil.isBlank(key) ? false : redisTemplate.hasKey(key);
    }

    public static void lpush(String key,Object value){
        redisTemplate.opsForList().leftPush(key,value);
    }

    public static Object rPop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }

    public static Long incr(String key,Long num){
        return redisTemplate.opsForValue().increment(key,num);
    }
}
