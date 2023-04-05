package com.example.dmreader.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dmreader.pojo.User;
import com.example.dmreader.vo.LoginVo;
import com.example.dmreader.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangchenyi
 */
public interface IUserService extends IService<User> {


    RespBean doLogin(LoginVo loginVo, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    /*
    * 登录
    * */
    /*
    *根据cookie获取用户
     */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
    //更新密码
    RespBean updatePassword(String userTicket, String password,HttpServletRequest request,HttpServletResponse response);

}
