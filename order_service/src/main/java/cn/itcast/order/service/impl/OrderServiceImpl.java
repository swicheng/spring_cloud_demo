package cn.itcast.order.service.impl;

import cn.itcast.order.entity.Order;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
