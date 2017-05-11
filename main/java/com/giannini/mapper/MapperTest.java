package com.giannini.mapper;

import com.alibaba.fastjson.JSON;
import org.springside.modules.utils.mapper.BeanMapper;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fenglin on 2017/5/11.
 */
public class MapperTest {

    public static void main(String[] args) {

        List<UserPO> pos = new LinkedList<UserPO>();
        UserPO user1 = new UserPO();
        user1.setUserid(1L);
        user1.setAddress("africa");
        user1.setAge(12);
        user1.setBirth(new Date());
        user1.setMarried(false);
        user1.setName("jack");
        user1.setSex(0);

        UserPO user2 = new UserPO();
        user2.setUserid(2L);
        user2.setAddress("europe");
        user2.setAge(14);
        user2.setBirth(new Date());
        user2.setMarried(true);
        user2.setName("rose");
        user2.setSex(1);

        pos.add(user1);
        pos.add(user2);

        System.out.println(JSON.toJSONString(pos));

        List<UserDTO> dtos = BeanMapper.mapList(pos, UserPO.class, UserDTO.class);

        System.out.println(JSON.toJSONString(dtos));

    }
}
