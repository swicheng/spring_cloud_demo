package cn.itcast.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@TableName("student")
public class Student {

    @TableId
    private String sNo;

    private String sName;

    private String sSex;

    private Integer sAge;

    private String sDept;

}
