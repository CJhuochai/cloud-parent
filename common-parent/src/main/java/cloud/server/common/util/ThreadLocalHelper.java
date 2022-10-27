package cloud.server.common.util;

import cn.hutool.core.util.StrUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
public class ThreadLocalHelper {
    private static final ThreadLocal<Map<String,Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void remove(){
        THREAD_LOCAL.remove();
    }

    public static void set(String key,String value){
        final Map<String, Object> map = getMap();
        map.put(key,value);
    }

    public static void setToken(String value){
        final Map<String, Object> map = getMap();
        map.put("token",value);
    }

    public static String get(String key){
        final Map<String, Object> map = getMap();
        return map.get(key) == null ? null : "";
    }

    public static String getToken(){
        final Object token = getMap().get("token");
        return StrUtil.isBlankIfStr(token) ? null : token.toString();
    }

    private static Map<String,Object> getMap(){
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map != null){
            return map;
        }
        map = new ConcurrentHashMap<>();
        THREAD_LOCAL.set(map);
        return map;
    }
}
