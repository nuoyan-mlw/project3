package com.crazycode.web.controller;

import com.crazycode.pojo.Orders;
import com.crazycode.service.OrderService;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @GetMapping("/order/queryOrder.do")
    public ModelAndView queryProduct()throws Exception{
        ModelAndView mv = new ModelAndView("pages/orders-page-list");
        List<Orders> orders = orderService.queryAllOrder();
        /*System.out.println(orders);*/
        mv.addObject("orders",orders);
        return mv;
    }

    //查看订单详情
    @GetMapping("/orders/findById.do/{id}")
    public ModelAndView queryProductById(@PathVariable("id") String oId)throws Exception{
        ModelAndView mv = new ModelAndView("pages/orders-show");
        Orders orders = orderService.queryOrderById(oId);
        mv.addObject("orders",orders);
        System.out.println(orders);
        return mv;
    }
}
