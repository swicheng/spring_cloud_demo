package cn.itcast.order.command;

import cn.itcast.order.entity.Product;
import com.netflix.hystrix.*;
import org.springframework.web.client.RestTemplate;

public class OrderCommand extends HystrixCommand<Product> {

    private RestTemplate restTemplate;

    private Long id;

    public OrderCommand(RestTemplate restTemplate, Long id) {
        super(setter());
        this.restTemplate = restTemplate;
        this.id = id;

    }


    private static Setter setter(){

        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("order_product");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("product");
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("order_product_pool");

        /**
         *  线程池配置
         *   withCoreSize： 线程池大小
         *   withKeepAliveTimeMinutes: 线程存活时间15秒
         *   withQueueSizeRejectionThreshold：队列等待的阀值为00，超过100执行拒绝策略
         */

        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties
                .Setter()
                .withCoreSize(50)
                .withKeepAliveTimeMinutes(15)
                .withQueueSizeRejectionThreshold(100);
        // 命令属性配置Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties
                .Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止
                .withExecutionTimeoutEnabled(false);

        return Setter.withGroupKey(groupKey)
                     .andCommandKey(commandKey)
                     .andThreadPoolKey(threadPoolKey)
                     .andThreadPoolPropertiesDefaults(threadPoolProperties)
                     .andCommandPropertiesDefaults(commandProperties);


    }

    @Override
    protected Product run() throws Exception {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }

    @Override
    protected Product getFallback() {

        Product product = new Product().setProductName("getFallback");

        return product;
    }
}
