package com.example.dmreader.exception;

import com.example.dmreader.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 全局异常*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private RespBeanEnum respBeanEnum;
    public RespBeanEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

}
