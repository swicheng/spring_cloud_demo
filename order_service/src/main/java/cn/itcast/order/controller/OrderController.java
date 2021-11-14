package cn.itcast.order.controller;

import cn.itcast.order.entity.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

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
    @GetMapping("/buy/{id}")
    public Order findorderById(@PathVariable Long id){

        return  orderService.getById(id);
    }



}
