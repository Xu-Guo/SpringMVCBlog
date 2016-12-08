package com.xuguo.interceptor;

import org.hibernate.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by xuxu on 12/4/16.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String loginStatus = (String) session.getAttribute("loginStatus");

        if(loginStatus == null || !loginStatus.equals("admin") ){
            System.out.println("##########################not login##########################");
            httpServletResponse.sendRedirect("/clientLogin");
            return false;
        } else {
            System.out.println("##########################Login checked!##########################");
            //httpServletRequest.getRequestDispatcher("/admin/users").forward(httpServletRequest,httpServletResponse);
            return true;
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


