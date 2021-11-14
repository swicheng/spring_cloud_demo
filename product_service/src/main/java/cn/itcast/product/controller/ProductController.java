package cn.itcast.product.controller;


import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/{id}")
     public Product getproductById(@PathVariable Long id){

         return productService.getById(id);
     }


}
