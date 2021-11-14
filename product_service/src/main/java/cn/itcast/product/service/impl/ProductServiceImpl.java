package cn.itcast.product.service.impl;

import cn.itcast.product.entity.Product;
import cn.itcast.product.mapper.ProductMapper;
import cn.itcast.product.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
