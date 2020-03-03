package com.ccb.logback.demo.interceptor;

import com.ccb.logback.demo.config.DataContext;
import org.slf4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id = (String)request.getParameter("id");
        String name = (String)request.getParameter("name");
        //MDC.put("id", id);

        DataContext.getContext().put("id", id);
        DataContext.getContext().put("name", name);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //MDC.remove("id");

        DataContext.getContext().clear();
    }
}
