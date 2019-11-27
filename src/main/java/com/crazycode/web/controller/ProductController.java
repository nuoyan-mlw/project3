package com.crazycode.web.controller;

import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/queryProduct.do")
    public ModelAndView queryProduct()throws Exception{
        ModelAndView mv = new ModelAndView("pages/product-list1");
        List<Product> products = productService.queryProduct();
        mv.addObject("products",products);
        return mv;
    }

}
