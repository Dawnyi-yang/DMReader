package com.example.dmreader.controller;


import com.example.dmreader.pojo.User;
import com.example.dmreader.service.IGoodService;
import com.example.dmreader.service.IOrderdeatilService;
import com.example.dmreader.service.IOrdersService;
import com.example.dmreader.vo.GoodVo;
import com.example.dmreader.vo.OrderVo;
import com.example.dmreader.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/outBound")
@Slf4j
public class outBoundController {
    @Autowired
    private IOrdersService iOrdersService;
    @RequestMapping(value="/doOutBound",method = RequestMethod.POST)
    public String doOutBound(Model model, User user, Long docnum){

        if(user==null){
            return "login";
        }
        model.addAttribute("user", user);
        OrderVo orderVo =iOrdersService.findOrderVoByOrderNum(docnum);
        if(orderVo.getState()!=0){
            model.addAttribute("errmsg", RespBeanEnum.OUTBOUND_ERROE.getMessage());
            return "outboundfail";
        }
        //iOrdersService.getGoods();//获取要出库的产品信息和数量，和要出库的订单进行对比，该过程通过app实现
        if(iOrdersService.outBound(docnum)){
            //model.addAttribute("state",RespBeanEnum.SUCCESS.getMessage());
            log.info("出库成功");
        }
        return "orderlist";
    }
}
