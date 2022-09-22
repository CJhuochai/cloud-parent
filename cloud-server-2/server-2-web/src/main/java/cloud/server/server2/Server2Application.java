package cloud.server.server2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Server2Application {
    public static void main(String[] args) {
        SpringApplication.run(Server2Application.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
