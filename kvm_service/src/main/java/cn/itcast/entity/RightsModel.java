package cn.itcast.entity;

import lombok.Data;

import java.util.List;

@Data
public class RightsModel {

    private Long resId;

    private List<RightType> ress;

}
