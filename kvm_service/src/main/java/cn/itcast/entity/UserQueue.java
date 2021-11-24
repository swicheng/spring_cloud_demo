package cn.itcast.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserQueue {

    private Long id;

    private Long userId;

    private Long resId;

    private  Long shareId;

    private String rightType;

    private String time;

    private String duration;

}
