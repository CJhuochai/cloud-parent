package cloud.server.server1.service1;

import cloud.server.server1.api.Server1Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create: 2022-09
 **/
@RestController
public class Server1Impl implements Server1Api {

    @Autowired
    private Environment environment;

    @Override
    public String getServerName() {
        return this.environment.getProperty("spring.application.name");
    }
}
