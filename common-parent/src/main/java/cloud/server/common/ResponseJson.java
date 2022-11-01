package cloud.server.common;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
public class ResponseJson {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseJson(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseJson success(){
        return assem(HttpStatus.HTTP_OK,null,null);
    }
    public static ResponseJson success(String msg, Object data){
        return assem(HttpStatus.HTTP_OK,msg,data);
    }
    public static ResponseJson success(Object data){
        return assem(HttpStatus.HTTP_OK,null,data);
    }

    public static ResponseJson error(){
        return assem(HttpStatus.HTTP_INTERNAL_ERROR,null,null);
    }
    public static ResponseJson error(String msg, Object data){
        return assem(HttpStatus.HTTP_INTERNAL_ERROR,msg,data);
    }
    public static ResponseJson error(Object data){
        return assem(HttpStatus.HTTP_INTERNAL_ERROR,null,data);
    }

    public static ResponseJson error(String msg){
        return assem(HttpStatus.HTTP_INTERNAL_ERROR,msg,null);
    }

    private static ResponseJson assem(Integer code, String msg, Object data){
        return new ResponseJson(code, msg, data);
    }

    public Map toMap(){
        return MapUtil.builder().put("code", code).put("msg", msg).put("data", data).build();
    }
}
