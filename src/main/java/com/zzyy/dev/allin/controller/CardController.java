package com.zzyy.dev.allin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.entity.User;
import com.zzyy.dev.allin.servie.CardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 16:28
 * @Description:
 */
@RequestMapping("/card")
@Controller
public class CardController {


    @Resource
    CardService cardService;

    @RequestMapping("/getHouse")
    @ResponseBody
    public House getHouse() {

        return cardService.getHouse();

    }

    @RequestMapping("/join")
    public String joinHouse(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam long num) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getSession().setAttribute("msg", "找不到用户");
            return "error";
        }

        String s = cardService.joinHouse(num, user);
        if (!StringUtils.equals("ok", s)) {
            request.getSession().setAttribute("msg", s);
            return "error";
        }

        //从后台获取对局数
        int max = cardService.getMaxIndex(num, user.getId());
        request.getSession().setAttribute("cardNum", ++max);


        return "cardRecord";
    }

    @RequestMapping("/add")
    public String addHouse(HttpServletRequest request,
                           HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getSession().setAttribute("msg", "找不到用户");
            return "error";
        }
        String times = request.getParameter("times");
        long time = Long.parseLong(times);

        String s = cardService.addHouse(time, user);
        if (!StringUtils.equals("ok", s)) {
            request.getSession().setAttribute("msg", s);
            return "error";
        }

        request.getSession().setAttribute("cardNum", 1);
        return "cardRecord";
    }

    @RequestMapping("/getRecord")
    @ResponseBody
    public JSONObject getRecord(HttpServletRequest request) {

        long num = Long.parseLong(request.getParameter("num"));
        return cardService.getRecord(num);

    }


    @RequestMapping("/edit")
    @ResponseBody
    public String edit(HttpServletRequest request) {

        JSONObject param = new JSONObject();

        Map<String, String[]> map = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            param.put(next.getKey(), next.getValue()[0]);
        }

        return cardService.edit(param);
    }
}
