package com.crazycode;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.mapper.RoleMapper;
import com.crazycode.mapper.UserMapper;
import com.crazycode.pojo.Product;
import com.crazycode.pojo.Users;
import com.crazycode.service.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Project3ApplicationTests {

    @Autowired
    private LoginRegisterService loginRegisterService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    public void login()throws Exception{
        Users users = new Users();
        users.setUsername("chenhao");
        users.setPassword("123456");
        //System.out.println(loginRegisterService.login(users));
    }

    @Test
    public void register()throws Exception{
        Users users = new Users();
        users.setUsername("111111");
        users.setPassword("111111");
        users.setEmail("111111");
        users.setPhoneNum("11111");
        users.setStatus(1L);
        int i = userService.addUser(users);
        System.out.println(i);
    }

    @Test
    public void permissionQuery()throws Exception{
        //System.out.println(userMapper.queryUserByID("ab07416d-a153-11e9-b4b3-74d02bd4fd82"));
        System.out.println(roleMapper.queryRolePermission("ab07416d-a153-11e9-b4b3-74d02bd4fd82"));
       //System.out.println(permissionMapper.queryPermissionById("4b56a3e3-a152-11e9-b4b3-74d02bd4fd82"));
    }

    @Test
    public void queryRole()throws Exception{
        /*System.out.println(roleService.queryRole());*/
        System.out.println(productService.queryProductById("0574b9ab9d7611e9aa6e74d02bd4fd82"));
    }

    @Test
    public void queryOrderById()throws Exception{
        System.out.println(productService.queryProduct());
    }

    //创建索引库
    @Test
    public void addLucene()throws Exception{
        //查询出所有的产品信息
        List<Product> products = productService.queryProduct();
        System.out.println(products);

        //指定索引库的路径
        Directory directory = FSDirectory.open(new File("d:\\index").toPath());
        //创建索引库写入对象,并告知写到哪里,使用指定的配置(分析器,默认使用的是标准分析器StandardAnalyzer)
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));

        for (Product product:products) {
            //创建文档(Document)
            Document document = new Document();

            //给文档创建不同的域对象
            Field productIdField = new StoredField("productId",product.getId());
            Field productNumField = new StoredField("productNum",product.getProductNum());
            Field productNameField = new TextField("productName",product.getProductName(), Field.Store.YES);
            Field cityNameField = new TextField("cityName",product.getCityName(), Field.Store.YES);
            Date date= product.getDepartureTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time =sdf.format(date);
            System.out.println(time);
            Field departureTimeField = new StoredField("departureTime",time);
            Field productPriceField = new TextField("productPrice",product.getProductPrice()+"", Field.Store.YES);
            Field productDescField = new TextField("productDesc",product.getProductDesc()+"", Field.Store.YES);
            Field productStatusField = new StoredField("productStatus",product.getProductStatus());
            document.add(productIdField);
            document.add(productNumField);
            document.add(productNameField);
            document.add(cityNameField);
            document.add(departureTimeField);
            document.add(productPriceField);
            document.add(productDescField);
            document.add(productStatusField);
            //把文档写入到索引库
            indexWriter.addDocument(document);
        }
        indexWriter.close();

    }

    //查询搜索
    @Test
    public void queryParser()throws Exception{
        //指定索引库的路径
        Directory directory = FSDirectory.open(new File("d:\\index").toPath());
        //创建indexReader对象,以读的方式打开索引库(看做是一个连接对象)
        IndexReader indexReader= DirectoryReader.open(directory);
        //创建IndexSearcher对象来发送查询请求
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //创建一个QueryParser对象
        //第一个参数: 当查询的字符串进行分词后到指定的域中查询文档
        //第二个参数: 指定使用分词器来对搜索的字符串进行分词
        QueryParser queryParser = new QueryParser("cityName",new IKAnalyzer());
        Query query = queryParser.parse("上海");
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println(topDocs.totalHits);
        for(ScoreDoc scoreDoc:topDocs.scoreDocs){
            int docid =scoreDoc.doc;
            //获取匹配到的文档id
            //根据docid就能获取指定的Document对象
            Document document =indexSearcher.doc(docid);
            //打印输出文档中对应域中所保存的数据
            System.out.println(document.get("productId"));
            System.out.println(document.get("productNum"));
            System.out.println(document.get("productName"));
            System.out.println(document.get("cityName"));
            System.out.println(document.get("departureTime"));
            System.out.println(document.get("productPrice"));
            System.out.println(document.get("productDesc"));
            System.out.println(document.get("productStatus"));
            System.out.println("--------------------------------------------");
        }
        indexReader.close();
    }
}
