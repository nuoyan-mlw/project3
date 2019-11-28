package com.crazycode.service;

import com.crazycode.pojo.Product;

import java.util.List;

public interface ProductService {

    //查询所有的产品信息
    public List<Product> queryProduct()throws Exception;

    //根据ID查询从产品信息
    public Product queryProductById(String pId)throws Exception;

    //添加产品
    public int addProduct(Product product)throws Exception;
}
