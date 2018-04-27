package org.cheng.controller;

import org.cheng.pojo.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cheng
 *         2018/4/27 10:21
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @GetMapping("/error")
    public String error() {

        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @GetMapping("/ajaxerror")
    public String ajaxError() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JSONResult getAjaxerror() {

        int a = 1 / 0;
        return JSONResult.ok();
    }
}
