package com.etc.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zwh
 * @date 2021/11/23
 * 登录拦截器
 */

public class AdminInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(AdminInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器前");
        Object object = request.getSession().getAttribute("currentUser");
        if(object!=null){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/tologin.action");
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
