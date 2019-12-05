package com.crazycode.web.controller;

import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        //System.out.println(product);
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
        if(ids != null){
            productService.deleteProduct(ids);
        }
        return "redirect:/product/queryProduct.do";
    }

    //开启产品
    @PostMapping("/product/openProduct.do")
    public String openProduct(String [] ids)throws Exception{
        if(ids != null){
            productService.openProduct(ids);
        }
        return "redirect:/product/queryProduct.do";
    }

    //关闭产品
    @PostMapping("/product/closeProduct.do")
    public String closeProduct(String [] ids)throws Exception{
        if(ids != null){
            productService.closeProduct(ids);
        }
        return "redirect:/product/queryProduct.do";
    }

    //产品搜索/product/searchProduct.do
    @PostMapping("/product/searchProduct.do")
    public ModelAndView searchProduct(String text)throws Exception{
        System.out.println("1111111");
        ModelAndView mv = new ModelAndView("pages/product-list1");

        //指定索引库的路径
        Directory directory = FSDirectory.open(new File("d:\\index").toPath());
        //创建indexReader对象,以读的方式打开索引库(看做是一个连接对象)
        IndexReader indexReader= DirectoryReader.open(directory);
        //创建IndexSearcher对象来发送查询请求
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //创建一个QueryParser对象
        //第一个参数: 当查询的字符串进行分词后到指定的域中查询文档
        //第二个参数: 指定使用分词器来对搜索的字符串进行分词
        QueryParser queryParser = new QueryParser("productDesc",new IKAnalyzer());
        Query query = queryParser.parse(text);

        TopDocs topDocs = indexSearcher.search(query, 100);

        List<Product> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(ScoreDoc scoreDoc:topDocs.scoreDocs){
            int docid =scoreDoc.doc;//获取匹配到的文档id
            //根据docid就能获取指定的Document对象
            Document document =indexSearcher.doc(docid);

            //把查找的信息放进Product
            Product product = new Product();

            product.setId(document.get("productId"));
            product.setProductName(document.get("productName"));
            product.setProductNum(document.get("productNum"));
            product.setCityName(document.get("cityName"));
            product.setDepartureTime(sdf.parse(document.get("departureTime")));
            product.setProductDesc(document.get("productDesc"));
            product.setProductPrice(Double.valueOf(document.get("productPrice")));
            product.setProductStatus(Integer.valueOf(document.get("productStatus")));

            list.add(product);
            System.out.println(product);
        }
        indexReader.close();
        mv.addObject("products",list);
        return mv;
    }

}
