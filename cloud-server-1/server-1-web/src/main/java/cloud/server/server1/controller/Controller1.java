package cloud.server.server1.controller;

import cloud.server.common.ResponseJson;
import cloud.server.common.util.RedisUtil;
import cloud.server.common.util.ThreadLocalHelper;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


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
    public Map a(){
        System.out.println("---------------------------进入controller");
        return ResponseJson.success(ThreadLocalHelper.getToken()).toMap();
    }

    @GetMapping("/login")
    public Object login(){
        final String s = UUID.fastUUID().toString();
        RedisUtil.set(s, UUID.fastUUID().toString(),1L, TimeUnit.MINUTES);
        return new JSONObject(MapUtil.builder().put("token",s).build(),true);
    }
}
