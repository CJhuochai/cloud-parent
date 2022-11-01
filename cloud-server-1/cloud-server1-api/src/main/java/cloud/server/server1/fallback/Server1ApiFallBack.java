package cloud.server.server1.fallback;

import cloud.server.common.feign.RemoteResponseJson;
import cloud.server.server1.api.Server1Api;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Slf4j
@Component
public class Server1ApiFallBack implements FallbackFactory<Server1Api> {
    @Override
    public Server1Api create(Throwable cause) {
        return () -> {
            final RemoteResponseJson<String> r = new RemoteResponseJson<>();
            r.setData("报错拉");
            return r;
        };
    }
}
