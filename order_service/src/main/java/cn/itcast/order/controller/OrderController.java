package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@RequestMapping("/order")
public class OrderController {




    @Resource
    private RestTemplate restTemplate;

    /**
     * 注入DiscoveryClient:
     *  springcloud提供的获取元数据的工具类
     *    调用方法获取服务的元数据信息
     */

    @Resource
    private EurekaDiscoveryClient discoveryClient;


    /**
     *
     * 基于ribbon的形式调用远程微服务
     *  1. 使用@LoadBalanced声明RestTemplate
     *  2. 使用服务名称替换ip地址
     */
    @GetMapping("/buy/{id}")
    public Product findById(@PathVariable Long id){


        // 根据元数据中的主机地址和端口号拼接请求微服务的URL
       Product product = restTemplate.getForObject("http://product-service/product/1",Product.class);

        return  product;
    }

    /**
     *
     * @param id
     * @return
     *  参数: 商品id
     *   通过订单系统，调用商品服务根据id查询商品信息
     *     1.需要配置商品对象
     *     2.需要调用商品服务
     *   使用java中的URLconnection，httpclient，okhttp
     */
//    @GetMapping("/buy/{id}")
//    public Product findById(@PathVariable Long id){
//
//
//        // 调用disconveryClient方法
//      List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT_SERVICE");
//
//      // 获取唯一的一个元数据
//      ServiceInstance instance = instances.get(0);
//
//      // 根据元数据中的主机地址和端口号拼接请求微服务的URL
//      ResponseEntity<Product> resP = restTemplate.getForEntity("http://"+instance.getHost()+":"+instance.getPort()+"/product/1",Product.class);
//
//      return  resP.getBody();
//    }



}
