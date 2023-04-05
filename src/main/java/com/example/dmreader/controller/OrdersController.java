package com.example.dmreader.controller;


import com.example.dmreader.pojo.User;
import com.example.dmreader.service.IOrdersService;
import com.example.dmreader.service.IUserService;
import com.example.dmreader.vo.OrderVo;
import com.example.dmreader.vo.RespBean;
import com.example.dmreader.vo.RespBeanEnum;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangchenyi
 */
@Controller
@RequestMapping("/orders")
@Slf4j
public class OrdersController  implements InitializingBean {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IOrdersService iOrdersService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisScript<Long> script;
    /*@Autowired
    private IOrderdeatilService iOrderdeatilService;*/
    @RequestMapping("/toList")
    public String toList(Model model, User user){

        model.addAttribute("user",user);
        model.addAttribute("ordersList",iOrdersService.findOrderVo());
        return "orderlist";
    }
    @RequestMapping("/toDetail/{docnum}")
    public String toDetail(Model model, User user, @PathVariable Long docnum ){
        model.addAttribute("user",user);


        //OrderVo orderVo=(OrderVo) redisTemplate.opsForValue().get("order:"+docnum);
        ValueOperations valueOperations=redisTemplate.opsForValue();
        Long state=valueOperations.increment("orderstate:"+docnum);
        if(state!=1){
            valueOperations.decrement("order:"+docnum);
            System.out.println("该订单正在出库中");
            return "orderlist";
        }
        model.addAttribute("goodsList",iOrdersService.findGoodVoByOrderNum(docnum));
        model.addAttribute("docnum",docnum);
        return "goodslist";
    }


    @RequestMapping(value="/doOutBound",method = RequestMethod.POST)
    public RespBean doOutBound(Model model, User user, Long docnum){

        if(user==null){
            return RespBean.error(RespBeanEnum.OUTBOUND_ERROE);
        }
        model.addAttribute("user", user);
        //OrderVo orderVo=(OrderVo) redisTemplate.opsForValue().get("order:"+docnum);
        ValueOperations valueOperations=redisTemplate.opsForValue();
        //Long state=valueOperations.increment("orderstate:"+docnum);
        Long state= ((Long) redisTemplate.execute(script, Collections.singletonList("orderstate:" + docnum), Collections.EMPTY_LIST));
        log.info("dooutbound" );
        if(state!=2){
            valueOperations.decrement("orderstate:"+docnum);
            return RespBean.error(RespBeanEnum.OUTBOUND_ERROE);
        }
        if(iOrdersService.outBound(docnum)){
            //model.addAttribute("state",RespBeanEnum.SUCCESS.getMessage());
            log.info("出库成功");
        }
        /*OrderVo orderVo =iOrdersService.findOrderVoByOrderNum(docnum);
        log.info(String.valueOf(orderVo.getState()));
        if(orderVo.getState()!=0){
            model.addAttribute("errmsg", RespBeanEnum.OUTBOUND_ERROE.getMessage());
            return "outboundfail";
        }
        //iOrdersService.getGoods();//获取要出库的产品信息和数量，和要出库的订单进行对比，该过程通过app实现
        if(iOrdersService.outBound(docnum)){
            //model.addAttribute("state",RespBeanEnum.SUCCESS.getMessage());
            log.info("出库成功");
        }*/
        return RespBean.success(docnum);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        List<OrderVo> list=iOrdersService.findOrderVo();
        if(CollectionUtils.isEmpty(list)){
            return;
        }
        for (OrderVo orderVo : list) {
            redisTemplate.opsForValue().set("orderstate:"+orderVo.getDocnum(),orderVo.getState());

            //redisTemplate.opsForValue().set("order:"+orderVo.getDocnum(),orderVo);
        }
    }
}
