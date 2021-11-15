package cn.itcast.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 *  商品实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


   private Long id;

   private String productName;

   private Integer status;

   private BigDecimal price;

   private String productDesc;

   private String caption;

   private Integer inventory;

}
