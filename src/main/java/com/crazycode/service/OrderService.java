package com.crazycode.service;

import com.crazycode.pojo.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    //查询所有的订单
    public List<Orders> queryAllOrder()throws Exception;

    //通过ID找订单和详情
    public Orders queryOrderById(String oId)throws Exception;
}
