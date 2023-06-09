package com.example.dmreader.exception;

import com.example.dmreader.vo.RespBean;
import com.example.dmreader.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e){
        if(e instanceof GlobalException){
            GlobalException ex=(GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        }
        else if(e instanceof BindException){
            BindException ex=(BindException) e;
            RespBean respBean=RespBean.error(RespBeanEnum.BIND_ERROE);
            respBean.setMessage("参数校验异常:"+ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;

        }
        log.info("异常信息" + e);
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
