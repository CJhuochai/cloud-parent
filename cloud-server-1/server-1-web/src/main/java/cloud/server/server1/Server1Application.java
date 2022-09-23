package cloud.server.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Server1Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(Server1Application.class, args);
        final Iterator<String> beanNamesIterator = run.getBeanFactory().getBeanNamesIterator();
        while (beanNamesIterator.hasNext()){
            System.out.println("--------------------:" + beanNamesIterator.next());
        }
    }
}
