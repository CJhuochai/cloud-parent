package cloud.server.common.config;

import cloud.server.common.interceptor.FeignInterceptor;
import cloud.server.common.redis.RedisConfig;
import cloud.server.common.redis.RedissonConfig;
import cloud.server.common.util.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Configuration
@Import({WebMvcConfig.class, RedisConfig.class, RedissonConfig.class})
public class BaseAutowiredBeanConfig {

    @Bean
    public RedisUtil redisUtil(RedisTemplate redisTemplate){
        return new RedisUtil(redisTemplate);
    }

    @Bean
    public FeignInterceptor feignInterceptor(){
        return  new FeignInterceptor();
    }
}
