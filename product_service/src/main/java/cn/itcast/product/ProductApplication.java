package cn.itcast.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("cn.itcast.product.mapper")
@SpringBootApplication
// 激活eurekaClient
//@EnableEurekaClient
@EnableDiscoveryClient
public class ProductApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class,args);

        System.out.println("启动完毕....");

    }

}
