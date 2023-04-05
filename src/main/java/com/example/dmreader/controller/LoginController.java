package com.example.dmreader.controller;

import com.example.dmreader.service.IUserService;
import com.example.dmreader.vo.LoginVo;
import com.example.dmreader.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService iUserService;

/*
不能用restcontroller,因为会自动给所有的方法加上respond body，会返回对象，而不是做页面跳转
* 跳转登录页面*/
    @RequestMapping("/toLogin")
    //用于处理请求地址映射的注解，用于映射一个请求或一个方法，可以用在类或方法上
    public String toLoging(){
        return "login";
    }
    /*
    *  登录功能
    *
    */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("{}",loginVo);//使用了lombok+@Slf4j，可以直接用log，是默认使用的

        return iUserService.doLogin(loginVo,request,response);
    }
}
