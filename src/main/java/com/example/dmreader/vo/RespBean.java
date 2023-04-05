package com.example.dmreader.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    /*
    * 公共返回对象
    * */
    private long code;
    private String message;
    private Object obj;
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),null);
    }//无返回对象的成功
    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),obj);
    }//有返回对象的成功
    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }
    //失败返回结果
    //直接传枚举，因为成功的状态只有一种（200），但失败的可能性有多种（404，403）
    public static RespBean error(RespBeanEnum respBeanEnum,Object obj){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),obj);
    }//重载
}
