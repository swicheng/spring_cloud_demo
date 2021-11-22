package cn.itcast.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_product")
public class Order {

   @TableId
   private Long id;

   private String productName;

   private Integer status;

   private BigDecimal price;

   private String productDesc;

   private String caption;

   private Integer inventory;

}
