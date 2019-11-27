package com.crazycode.service;

import com.crazycode.pojo.Product;

import java.util.List;

public interface ProductService {

    //查询所有的产品信息
    public List<Product> queryProduct()throws Exception;
}
