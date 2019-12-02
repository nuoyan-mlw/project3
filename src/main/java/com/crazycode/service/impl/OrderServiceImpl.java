package com.crazycode.service.impl;

import com.crazycode.mapper.OrderMapper;
import com.crazycode.pojo.Orders;
import com.crazycode.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> queryAllOrder() throws Exception {
        return orderMapper.queryAllOrder();
    }

    @Override
    public Orders queryOrderById(String oId) throws Exception {
        return orderMapper.queryOrderById(oId);
    }
}
