package cloud.server.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Server1Application {
    public static void main(String[] args) {
        SpringApplication.run(Server1Application.class,args);
    }
}
