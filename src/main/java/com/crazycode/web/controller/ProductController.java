package com.crazycode.web.controller;

import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
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

    //添加产品
    @PostMapping("/product/addProduct.do")
    public String addProduct(Product product)throws Exception{
        System.out.println(product);
        int i = productService.addProduct(product);
        if(i == 1){
            return "redirect:/product/queryProduct.do";
        }else {
            return "pages/product-add";
        }
    }

    //删除产品
    @PostMapping("/product/deleteProduct.do")
    public String deleteProduct(String [] ids)throws Exception{
        System.out.println(ids);
        System.out.println(ids[0]);

        return "";
    }


}
