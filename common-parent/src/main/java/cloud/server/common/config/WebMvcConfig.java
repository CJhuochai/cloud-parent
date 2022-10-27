package cloud.server.common.config;

import cloud.server.common.interceptor.AccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: limiting-demo
 * @description:
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/login");
    }

    @Bean
    public HandlerInterceptor getInterceptor(){
        return new AccessInterceptor();
    }


}
