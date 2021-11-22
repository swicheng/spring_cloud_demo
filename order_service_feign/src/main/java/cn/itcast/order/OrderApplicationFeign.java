package cn.itcast.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableDiscoveryClient
// 激活Feign
@EnableFeignClients
// 激活hystrix
@EnableCircuitBreaker
// 激活hystrix的web监控平台
@EnableHystrixDashboard
public class OrderApplicationFeign {


    /**
     * 使用spring提供的RestTemplate发送http请求到商品服务
     *    1.创建RestTemplate对象交给容器管理
     *    2.在使用的时候，调用其方法完成操作(getXX，postxxx)
     *
     */

    public static void main(String[] args) {

        SpringApplication.run(OrderApplicationFeign.class,args);

        System.out.println("order_service_feign 启动完毕....");

    }

}
