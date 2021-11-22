package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@RequestMapping("/order")
/**
 * @DefaultProperties : 指定此接口中公共的熔断设置
 *    如果在@DefaultPropeties指定了公共的降级方法
 *    在HystrixCommand不需要单独指定了
 */
@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {


    @Resource
    private RestTemplate restTemplate;

    /**
     *
     * @param id
     * @return
     *
     *   使用注解配置熔断保护
     *     fallbackmethod：配置熔断之后的降级方法
     *
     */
    @HystrixCommand()
    @GetMapping("/buy/{id}")
    public Product findById(@PathVariable Long id){


        // 根据元数据中的主机地址和端口号拼接请求微服务的URL
       Product product = restTemplate.getForObject("http://product-service/product/1",Product.class);

        return  product;
    }

    /**
     *  指定统一的降级方法
     *    参数: 没有参数
     */

    /**
     *  降级方法
     *    和需要收到保护的方法的返回值一致
     *    方法参数一致
     */

    public Product defaultFallBack(){

        Product product = new Product();
        product.setProductName("默认的触发降级方法");

        return  product;
    }

    public Product orderFallBack(Long id){

        Product product = new Product();
        product.setProductDesc("触发降级方法");
        return  product;
    }


}
