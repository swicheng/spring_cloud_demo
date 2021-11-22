package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
// turbine 配置
@EnableTurbine
@EnableHystrixDashboard
public class TurbineApplication {


    public static void main(String[] args) {

        SpringApplication.run(TurbineApplication.class ,args);
    }

}
