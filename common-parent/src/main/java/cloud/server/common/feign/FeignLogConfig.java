package cloud.server.common.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
