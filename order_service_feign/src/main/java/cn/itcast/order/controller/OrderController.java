package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import cn.itcast.order.feign.ProductFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/order")
public class OrderController {


    @Resource
    private ProductFeignClient productFeignClient;


    @GetMapping("/buy/{id}")
    public Product findById(@PathVariable Long id){


        // 根据元数据中的主机地址和端口号拼接请求微服务的URL
      // Product product = restTemplate.getForObject("http://product-service/product/1",Product.class);

        Product product = productFeignClient.findById(id);

        return  product;
    }

}
