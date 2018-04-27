package org.cheng.controller;

import org.cheng.pojo.JSONResult;
import org.cheng.pojo.SysUser;
import org.cheng.pojo.User;
import org.cheng.utils.JsonUtils;
import org.cheng.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cheng
 *         2018/4/27 21:06
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JSONResult test() {

        strRedis.opsForValue().set("cheng", "hello 诚 ~~~");

        SysUser user = new SysUser();
        user.setId("1001");
        user.setUsername("cheng ");
        user.setNickname("cheng ");
        user.setPassword("zz");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);

        return JSONResult.ok(jsonUser);
        // return JSONResult.ok(strRedis.opsForValue().get("cheng"));
    }

    @RequestMapping("/getJsonList")
    public JSONResult getJsonList() {

        User user = new User();
        user.setName("cheng");
        user.setAge(21);
        user.setBirthday(new Date());
        user.setPassword("zzz");


        User u1 = new User();
        u1.setAge(19);
        u1.setName("cheng 2");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("cheng 3");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);


        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JSONResult.ok(userListBorn);
    }
}
