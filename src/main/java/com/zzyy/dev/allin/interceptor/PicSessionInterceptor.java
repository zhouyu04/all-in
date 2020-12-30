package com.zzyy.dev.allin.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: zhouyu
 * @Date: 2020/12/30 15:37
 * @Description:
 */
@Component
public class PicSessionInterceptor implements HandlerInterceptor {


    private static Logger log = LoggerFactory.getLogger(PicSessionInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("进入拦截器...");

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        if (StringUtils.equalsIgnoreCase("darling", user)) {
            return true;
        }

        request.getRequestDispatcher("/toPicture").forward(request, response);
        return false;

    }

}
