package com.crazycode.mapper;

import com.crazycode.pojo.Orders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    //查询所有的订单
    public List<Orders> queryAllOrder()throws Exception;
}
