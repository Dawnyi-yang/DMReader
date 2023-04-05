package com.example.dmreader.controller;



import com.example.dmreader.pojo.User;
import com.example.dmreader.vo.RespBean;
import com.example.dmreader.vo.RespBeanEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangchenyi
 * @since 2023-03-29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    public RespBean info(User user){
        return RespBean.success(user);
    }
}
