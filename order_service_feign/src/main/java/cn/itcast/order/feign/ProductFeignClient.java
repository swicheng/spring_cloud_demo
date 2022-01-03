package cn.itcast.order.feign;

import cn.itcast.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *  声明需呀调用的微服务名称
 * @FeignClient
 *    name：服务提供者的名称
 *    fallback: 配置熔断发生降级方法
 *              实现类
 */
@FeignClient(name="product-service" , fallback = ProductFeignClientCallBack.class)
public interface ProductFeignClient {

    /**
     *  配置需要调用的服务接口
     */
    @GetMapping("/product/{id}")
    Product findById(@PathVariable("id") Long id);

}
