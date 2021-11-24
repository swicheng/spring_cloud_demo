package cn.itcast.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueueModel {

    private Long id;

    private List<RightsModel> res;

    private List<User> users;

}
