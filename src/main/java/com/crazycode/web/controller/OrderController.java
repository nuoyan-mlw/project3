package com.crazycode.web.controller;

import com.crazycode.pojo.Orders;
import com.crazycode.pojo.Product;
import com.crazycode.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/queryOrder.do")
    public ModelAndView queryProduct()throws Exception{
        ModelAndView mv = new ModelAndView("pages/orders-page-list");
        List<Orders> orders = orderService.queryAllOrder();
        mv.addObject("orders",orders);
        return mv;
    }
}
