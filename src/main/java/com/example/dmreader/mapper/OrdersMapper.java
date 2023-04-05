package com.example.dmreader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dmreader.pojo.Orders;
import com.example.dmreader.vo.GoodVo;
import com.example.dmreader.vo.OrderVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangchenyi
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    List<OrderVo> findOrderVo();
    
    OrderVo findOrderVoByOrderNum(Long docnum);

    List<GoodVo> findGoodVoByOrderNum(Long docnum);

    void outBound(Long docnum);

    void preBound(Long docnum);
}
