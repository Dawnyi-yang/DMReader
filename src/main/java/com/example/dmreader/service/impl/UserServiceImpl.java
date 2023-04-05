package com.example.dmreader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dmreader.exception.GlobalException;
import com.example.dmreader.mapper.UserMapper;
import com.example.dmreader.pojo.User;
import com.example.dmreader.service.IUserService;
import com.example.dmreader.utils.CookieUtil;
import com.example.dmreader.utils.MD5Util;
import com.example.dmreader.utils.UUIDUtil;
import com.example.dmreader.utils.ValidatorUtil;
import com.example.dmreader.vo.LoginVo;
import com.example.dmreader.vo.RespBean;
import com.example.dmreader.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangchenyi
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        String mobile=loginVo.getMobile();
        String password=loginVo.getPassword();
        /*if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if(!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/
        User user=userMapper.selectById(mobile);
        if(user==null){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //log.info(MD5Util.formPassToDBPass(password,user.getSalt()));
        if(!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            log.info("not sucess");
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        String ticket=UUIDUtil.uuid();
        //request.getSession().setAttribute(ticket,user);
        //数据存入redis
        redisTemplate.opsForValue().set("user:"+ticket,user);
        log.info("sucess");
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success(ticket);
    }
    public User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response){
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user=(User)redisTemplate.opsForValue().get("user:"+userTicket);
        if(user!=null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }

    //更新数据库时，要处理redis里面的数据，最简单的方式是通过直接删除redis里面的数据
    @Override
    public RespBean updatePassword(String userTicket, String password,HttpServletRequest request,HttpServletResponse response) {
        User user=getUserByCookie(userTicket,request,response);
        if(user==null){
            throw new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Util.inputPassToDBPass(password,user.getSalt()));
        int result=userMapper.updateById(user);
        if(result==1){
            redisTemplate.delete("user:"+userTicket);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }
}
