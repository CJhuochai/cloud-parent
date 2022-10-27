package cloud.server.common.exception;

import cn.hutool.http.HttpStatus;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
public class BizException extends RuntimeException {
    private Integer code;

    public BizException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public static BizException throwSimpleException(String msg){
        return new BizException(msg, HttpStatus.HTTP_INTERNAL_ERROR);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
