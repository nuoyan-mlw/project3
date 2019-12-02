package com.crazycode.mapper;

import com.crazycode.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {

    //查询所有的产品信息
    public List<Product> queryProduct()throws Exception;

    //根据ID查询从产品信息
    public Product queryProductById(String pId)throws Exception;

    //添加产品
    public int addProduct(Product product)throws Exception;

    //删除商品
    public int deleteProduct(String  pId)throws Exception;

    //开启商品
    public void openProduct(String pid)throws Exception;

    //关闭商品
    public void closeProduct(String pid)throws Exception;
}
