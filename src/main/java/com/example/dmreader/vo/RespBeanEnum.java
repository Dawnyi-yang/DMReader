package com.example.dmreader.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    /*
     * 公共返回对象枚举类
     * */
    //通用
    SUCCESS(200,"成功"),
    ERROR(500,"服务端异常"),
    //登录
    LOGIN_ERROR(500210,"用户名或密码错误"),
    MOBILE_ERROR(500211,"手机号码格式不正确"),
    BIND_ERROE(500212,"参数校验异常"),
    MOBILE_NOT_EXIST(500213,"手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500214,"密码修改失败"),
    OUTBOUND_ERROE(500500,"出库异常");

    private final Integer code;
    private final String message;
}
