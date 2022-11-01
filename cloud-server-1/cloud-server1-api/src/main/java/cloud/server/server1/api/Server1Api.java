package cloud.server.server1.api;

import cloud.server.common.ResponseJson;
import cloud.server.common.feign.RemoteResponseJson;
import cloud.server.server1.fallback.Server1ApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @create: 2022-09
 **/
@FeignClient(value = "cloud.server-1",path = "/api/server1",fallbackFactory = Server1ApiFallBack.class)
public interface Server1Api {

    @GetMapping("/getServerName")
    RemoteResponseJson<String> getServerName();
}
