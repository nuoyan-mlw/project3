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

    @Override
    public Product queryProductById(String pId) throws Exception {
        return productMapper.queryProductById(pId);
    }

    @Override
    public int addProduct(Product product) throws Exception {
        return productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(String[] ids) throws Exception {
        for (int i = 0;i < ids.length;i++){
            productMapper.deleteProduct(ids[i]);
        }

    }

    @Override
    public void openProduct(String[] ids) throws Exception {
        for (int i = 0;i < ids.length;i++){
            productMapper.openProduct(ids[i]);
        }
    }

    @Override
    public void closeProduct(String[] ids) throws Exception {
        for (int i = 0;i < ids.length;i++){
            productMapper.closeProduct(ids[i]);
        }
    }
}
