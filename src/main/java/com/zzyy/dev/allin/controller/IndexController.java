package com.zzyy.dev.allin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zhouyu
 * @Date: 2020/12/25 16:39
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

}
