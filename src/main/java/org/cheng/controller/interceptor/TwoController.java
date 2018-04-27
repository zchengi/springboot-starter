package org.cheng.controller.interceptor;

import org.cheng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cheng
 *         2018/4/27 22:23
 */
@Controller
@RequestMapping("two")
public class TwoController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {

        modelMap.addAttribute("name", "cheng2");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {

        return "thymeleaf/center/center";
    }

    @GetMapping("/test")
    public String text(ModelMap modelMap) {

        User user = new User();
        user.setName("manager");
        user.setAge(21);
        user.setPassword("zzz");
        user.setBirthday(new Date());
        user.setDesc("<font color='gray'><b>hello</b></font>");
        modelMap.addAttribute("user", user);

        User user1 = new User();
        user1.setName("www");
        user1.setAge(18);
        user1.setPassword("www");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setName("zzz");
        user2.setAge(19);
        user2.setPassword("ccc");
        user2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        modelMap.put("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(User user) {

        System.out.println(user.getName());

        return "redirect:/th/test";
    }
}
