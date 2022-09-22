package cloud.server.server1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: limiting-demo
 * @description:
 * @author: Jian Chen
 * @create: 2022-09
 **/
@RestController
@RequestMapping("/c1")
public class Controller1 {

    @GetMapping("/a")
    public Object a(String msg){
        return msg;
    }
}
