package com.zzyy.dev.allin.controller;

import com.zzyy.dev.allin.entity.Kvs;
import com.zzyy.dev.allin.entity.User;
import com.zzyy.dev.allin.servie.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: zhouyu
 * @Date: 2020/12/25 16:39
 * @Description:
 */
@Controller
public class IndexController {


    @Resource
    IndexService indexService;

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("/toPicture")
    public String toPicture() {
        return "toPicture";
    }


    @RequestMapping("/toCard")
    public String toCard() {
        return "toCard";
    }

    @RequestMapping("/error/page")
    public String error() {
        return "error";
    }

    @RequestMapping("/picture")
    public String picture() {
        return "picture";
    }

    @RequestMapping("/check/code")
    @ResponseBody
    public boolean checkCode(HttpServletRequest request, HttpServletResponse response) {

        String code = request.getParameter("code");

        Kvs kvs = indexService.getCodeByKey("P_CODE");

        if (kvs == null) {
            return false;
        }
        String value = kvs.getValue();
        if (!StringUtils.equals(code, value)) {
            return false;
        }

        request.getSession().setAttribute("user", "darling");
        return true;
    }

    @RequestMapping("/check/user")
    @ResponseBody
    public User checkUser(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");

        User user = indexService.getUserByname(username);

        request.getSession().setAttribute("user", user);
        return user;
    }

    @RequestMapping("/card")
    public String card() {
        return "card";
    }

    @RequestMapping("/quit")
    @ResponseBody
    public boolean quit(HttpServletRequest request, HttpServletResponse response) {


        request.getSession().removeAttribute("user");
        return true;
    }


}
