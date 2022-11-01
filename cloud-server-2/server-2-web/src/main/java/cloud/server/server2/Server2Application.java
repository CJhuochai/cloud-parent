package cloud.server.server2;


import cloud.server.common.config.BaseAutowiredBeanConfig;
import cloud.server.common.feign.FeignLogConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cloud.server.server1.api"},defaultConfiguration = FeignLogConfig.class)
@ComponentScan("cloud.server.*")
@Import({BaseAutowiredBeanConfig.class})
public class Server2Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(Server2Application.class, args);
        final Iterator<String> beanNamesIterator = run.getBeanFactory().getBeanNamesIterator();
        while (beanNamesIterator.hasNext()){
            System.out.println("------------------------"+ beanNamesIterator.next());
        }
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
