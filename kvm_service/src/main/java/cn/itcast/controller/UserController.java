package cn.itcast.controller;

import cn.itcast.entity.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @GetMapping("/query")
    public Map<String,Object> query(){

        List<UserQueue> userList = new ArrayList<>();

        userList.add(new UserQueue(1001l,1l,1l,3l,"分享","today","20"));
        userList.add(new UserQueue(1002l,2l,1l,3l,"分享推源","today","20"));
        userList.add(new UserQueue(1003l,3l,1l,3l,"分享推源","today","28"));

        userList.add(new UserQueue(1004l,4l,2l,3l,"分享","today","20"));
        userList.add(new UserQueue(1005l,5l,3l,3l,"分享推源","today","20"));
        userList.add(new UserQueue(1006l,6l,2l,3l,"分享推源","today","28"));

        Map<String,Object> map = new HashMap<>();
        List<UserQueueModel> modelist = new ArrayList<>();
        long flag = -1;

        for (UserQueue queue: userList) {

            UserQueueModel userQueueModel = new UserQueueModel();
            userQueueModel.setId(queue.getId());

            RightsModel rightsModel = new RightsModel();
            rightsModel.setResId(queue.getResId());
            List<RightType> rightTypeList = new ArrayList<>();
            for (UserQueue uqueue:userList) {

                if (uqueue.getResId() == rightsModel.getResId()){
                    rightTypeList.add(new RightType(uqueue.getRightType(), uqueue.getTime(),uqueue.getDuration()));
                }
            }
            rightsModel.setRess(rightTypeList);

            userQueueModel.setRes(Arrays.asList(rightsModel));

            List<User> ulist = new ArrayList<>();
            ulist.add(new User(queue.getUserId().toString(),"se"+queue.getUserId().toString()));

            userQueueModel.setUsers(ulist);

            modelist.add(userQueueModel);
        }
        map.put("items",modelist);

        return map;
    }

}
