package cn.itcast.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//激活eurekaserver
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class,args);
        System.out.println("eureka 执行完毕....");

    }

}
