/*
package com.ccb.logback.demo.filter;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String id = (String)servletRequest.getParameter("id");
        MDC.put("id", id);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove("id");
        }
    }

    @Override
    public void destroy() {

    }
}
*/
