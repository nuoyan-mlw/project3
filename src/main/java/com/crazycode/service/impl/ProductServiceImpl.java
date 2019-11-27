package com.crazycode.service.impl;

import com.crazycode.mapper.ProductMapper;
import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryProduct() throws Exception {
        return productMapper.queryProduct();
    }
}
