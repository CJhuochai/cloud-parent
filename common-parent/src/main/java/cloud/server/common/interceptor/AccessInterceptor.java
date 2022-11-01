package cloud.server.common.interceptor;

import cloud.server.common.exception.BizException;
import cloud.server.common.util.RedisUtil;
import cloud.server.common.util.ThreadLocalHelper;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/

public class AccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("---------------------------AccessInterceptor进来拉");
        final String token = this.getToken(request);
        if (!RedisUtil.hasKey(token)){
            info(response);
            return false;
        }
        ThreadLocalHelper.setToken(token);
        return true;
    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)){
            final Object token1 = request.getParameter("token");
            token = StrUtil.isBlankIfStr(token1) ? null : token1.toString();
        }
        return token;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("---------------------------AccessInterceptor完事拉");
        ThreadLocalHelper.remove();
    }

    private void info(HttpServletResponse response) throws IOException {
       /* Map<String,Object> resutlMap = new HashMap<>();
        resutlMap.put("code", 500);
        resutlMap.put("msg", "未登录");
        final String s = JSON.toJSONString(resutlMap);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(s);*/
       throw BizException.throwSimpleException("认证不通过");
    }
}
