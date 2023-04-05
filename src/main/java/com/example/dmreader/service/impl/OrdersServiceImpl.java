package com.example.dmreader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dmreader.mapper.OrdersMapper;
import com.example.dmreader.pojo.Orders;
import com.example.dmreader.service.IOrdersService;
import com.example.dmreader.vo.GoodVo;
import com.example.dmreader.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangchenyi
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<OrderVo> findOrderVo(){
        return ordersMapper.findOrderVo();
    }
    @Override
    public OrderVo findOrderVoByOrderNum(Long docnum){
        return ordersMapper.findOrderVoByOrderNum(docnum);
    }
    @Override
    public List<GoodVo> findGoodVoByOrderNum(Long docnum){

        return ordersMapper.findGoodVoByOrderNum(docnum);
    }
    public boolean outBound(Long docnum){
        OrderVo orderVo=findOrderVoByOrderNum(docnum);
        if(orderVo.getState()==0||orderVo.getState()==1){
            //orderVo.setState(2);
            //ordersMapper.updateById(orderVo);
            ordersMapper.outBound(docnum);
            return true;
        }
        return false;
    }
    public boolean preBound(Long docnum){
        OrderVo orderVo=findOrderVoByOrderNum(docnum);
        if(orderVo.getState()==0){
            //orderVo.setState(2);
            //ordersMapper.updateById(orderVo);
            ordersMapper.preBound(docnum);
            return true;
        }
        return false;
    }
}
