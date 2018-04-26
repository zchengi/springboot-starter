package org.cheng.controller;

import org.cheng.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cheng
 *         2018/4/26 17:08
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @GetMapping("center")
    public String center(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/center/center";
    }
}
