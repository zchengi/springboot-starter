package org.cheng.controller;

import org.cheng.pojo.JSONResult;
import org.cheng.pojo.SysUser;
import org.cheng.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author cheng
 *         2018/4/27 12:49
 */
@RestController
@RequestMapping("mybatis")
public class MybatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("cheng " + new Date());
        user.setNickname("cheng " + new Date());
        user.setPassword("cheng");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {

        SysUser user = new SysUser();
        user.setId("1001");
        user.setUsername("1001-update " + new Date());
        user.setNickname("1001-update " + new Date());
        user.setPassword("1001-update");

        userService.updateUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/queryUserListPaged")
    public JSONResult queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }

        int pageSize = 3;

        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JSONResult queryUserByIdCustom(String userId) {

        return JSONResult.ok(userService.queryUserByIdCustom(userId));
    }


    @RequestMapping("/saveUserTransactional")
    public JSONResult saveUserTransactional() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("cheng " + new Date());
        user.setNickname("cheng " + new Date());
        user.setPassword("zz");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransaction(user);

        return JSONResult.ok("保存成功");
    }
}

