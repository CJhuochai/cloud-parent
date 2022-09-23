package cloud.server.server1.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @create: 2022-09
 **/
@FeignClient(value = "cloud.server-1",path = "/api/server1")
public interface Server1Api {

    @GetMapping("/getServerName")
    String getServerName();
}
