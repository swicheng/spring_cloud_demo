package cn.itcast.product.controller;


import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @GetMapping("/{id}")
     public Product getproductById(@PathVariable Long id){

//        try {
//          //  Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
          Product product = productService.getById(id);
          product.setProductName("访问的服务的地址:"+ip+": "+port);
          return product;
     }


}
