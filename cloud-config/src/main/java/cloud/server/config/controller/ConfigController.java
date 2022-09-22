package cloud.server.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jian Chen
 * @create: 2022-09
 **/
@RequestMapping("/info")
@RestController
@RefreshScope
public class ConfigController {

    @Value("${dataurl.name}")
    private String name;
    @Value("${dataurl.password}")
    private String passWord;
    @Value("${app.name}")
    private String appName;
    @Value("${sms}")
    private String sms;

    @GetMapping("/info")
    public Object info(){
        return "数据库信息:name=" + this.name + ",passWord=" + this.passWord + ",appname=" + this.appName + ",sms=" + this.sms;
    }
}
