package com.xuguo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by xuxu on 12/4/16.
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            System.out.println("##########################preHandle##########################");
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

        if (modelAndView.getModelMap().containsKey("status")) {

            String status = (String) modelAndView.getModelMap().get("status");

            if (status.equals("SUCCESS!")) {

                status = "Authentication " + status;

                modelAndView.getModelMap().put("status", status);

            }

        }
        System.out.println("#########################afterCompletion#########################");
    }

    @Override

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@afterCompletion@@@@@@@@@@@@@@@@@@@@@@@@@@");


    }

}


