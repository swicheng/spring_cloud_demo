package cn.itcast.service;

import cn.itcast.entity.*;

import java.util.*;

public class PrivilegeQuery {

    public static void main(String[] args) {


        List<UserQueue> userList = new ArrayList<>();

        userList.add(new UserQueue(1001l,1l,1l,3l,"分享","today","20"));
        userList.add(new UserQueue(1002l,2l,1l,3l,"分享推源","today","20"));
        userList.add(new UserQueue(1003l,3l,1l,3l,"分享推源","today","28"));

        userList.add(new UserQueue(1004l,4l,2l,3l,"分享","today","20"));
        userList.add(new UserQueue(1005l,5l,3l,3l,"分享推源","today","20"));
        userList.add(new UserQueue(1006l,6l,2l,3l,"分享推源","today","28"));

        Map<String,Object> map = new HashMap<>();
        List<UserQueueModel> modelist = new ArrayList<>();

        for (UserQueue queue: userList) {

            UserQueueModel userQueueModel = new UserQueueModel();
            userQueueModel.setId(queue.getId());

            RightsModel rightsModel = new RightsModel();
            if (userQueueModel.getRes()!=null && userQueueModel.getRes().stream().anyMatch(rights -> {
                return rights.getResId() != queue.getResId();
            })){

                rightsModel.setResId(queue.getResId());
                List<RightType> rlist = new ArrayList<>();
                for (UserQueue uqueue:userList) {
                    if (rightsModel.getResId() == uqueue.getResId()){
                        RightType rightType = new RightType(uqueue.getRightType(),uqueue.getTime(),uqueue.getDuration());
                        rlist.add(rightType);
                    }
                }
                if (rlist.size()>0){
                    rightsModel.setRess(rlist);
                }
            }

            userQueueModel.setRes(Arrays.asList(rightsModel));

            List<User> ulist = new ArrayList<>();
            ulist.add(new User(queue.getUserId().toString(),"se"));

            userQueueModel.setUsers(ulist);

            modelist.add(userQueueModel);
        }



    }

}
