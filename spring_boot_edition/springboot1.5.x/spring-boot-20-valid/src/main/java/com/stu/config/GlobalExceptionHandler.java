package com.stu.config;

import com.stu.utils.EResultCode;
import com.stu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.stu.controller"})
public class GlobalExceptionHandler {


    /**
     * 方法验证器失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        result.getFieldErrors().forEach((item) -> {
            //FieldError 获取到错误提示
            String message = item.getDefaultMessage();
            //获取错误的属性的名字
            String field = item.getField();
            errorMap.put(field, message);
            log.error(field + ":" + message);
        });
        return R.fail(EResultCode.ERROR).setData(errorMap);
    }


    /**
     * 全局处理其他的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        log.error(e.getMessage());
        return R.fail(EResultCode.ERROR, e.getMessage());
    }
}
