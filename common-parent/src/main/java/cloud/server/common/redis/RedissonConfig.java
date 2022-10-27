package cloud.server.common.redis;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Slf4j
@Configuration
public class RedissonConfig {
    @Resource
    private RedisProperties redisProperties;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(){
        log.info("----------------------初始化Redisson");
        Config config = new Config();
        final SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort());
        singleServerConfig.setDatabase(redisProperties.getDatabase());
        final String password = redisProperties.getPassword();
        if (StrUtil.isNotBlank(password)){
            singleServerConfig.setPassword(password);
        }
        return Redisson.create(config);
    }
}
