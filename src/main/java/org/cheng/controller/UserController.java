package org.cheng.controller;

import org.cheng.pojo.JSONResult;
import org.cheng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * RestController = Controller + ResponseBody
 *
 * @author cheng
 *         2018/4/25 20:38
 */
//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();

        user.setName("cheng");
        user.setAge(21);
        user.setBirthday(new Date());
        user.setPassword("zzz");

        return user;
    }

    @GetMapping("/getUserJson")
    public JSONResult getUserJson() {
        User user = new User();

        user.setName("cheng");
        user.setAge(21);
        user.setBirthday(new Date());
        user.setPassword("zzz");
        user.setDesc(" z z c c c ");

        return JSONResult.ok(user);
    }
}
