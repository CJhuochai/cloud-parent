package cloud.server.common.interceptor;

import cloud.server.common.util.ThreadLocalHelper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Slf4j
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("----------------------feign的拦截器进入");
        requestTemplate.header("token", ThreadLocalHelper.getToken());
    }

}
