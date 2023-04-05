package com.example.dmreader.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dmreader.pojo.Good;
import com.example.dmreader.pojo.Orders;
import com.example.dmreader.vo.GoodVo;
import com.example.dmreader.vo.OrderVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangchenyi
 */
public interface IOrdersService extends IService<Orders> {
    public List<OrderVo> findOrderVo();

    public OrderVo findOrderVoByOrderNum(Long docnum);

    public List<GoodVo> findGoodVoByOrderNum(Long docnum);

    public boolean outBound(Long docnum);
}
