package cloud.server.server2.controller;

import cloud.server.server1.api.Server1Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@RestController
@RequestMapping("/c2")
public class Controller2 {

    @Autowired
    private Server1Api server1Api;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/a")
    public Object a(){
        final String forObject = this.restTemplate.getForObject("http://192.168.101.84:8081/api/server1/c1/a?msg=你好", String.class);
        return forObject;
    }

    @GetMapping("/server-name")
    public Object getServerName(){
        return this.server1Api.getServerName();
    }
}
