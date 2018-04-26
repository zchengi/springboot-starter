package org.cheng.controller;

import org.cheng.pojo.JSONResult;
import org.cheng.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 *         2018/4/25 20:26
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot ~~~";
    }

    @GetMapping("/getResource")
    public JSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JSONResult.ok(bean);
    }
}
