package cloud.server.common.exception;

import cloud.server.common.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = BizException.class)
    public Map bizException(BizException e){
        return ResponseJson.error(e.getMessage()).toMap();
    }

    @ExceptionHandler(value = Exception.class)
    public Map exception(Exception e){
        log.error(e.getMessage(),e);
        return ResponseJson.error(e.getMessage()).toMap();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Map runtimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return ResponseJson.error(e.getMessage()).toMap();
    }
    @ExceptionHandler(value = ArithmeticException.class)
    public void arithmeticException(ArithmeticException e){
        log.error(ArithmeticException.class.getName(),e.getMessage());
    }
}
