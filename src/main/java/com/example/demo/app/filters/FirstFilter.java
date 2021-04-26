package com.example.demo.app.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "FirstFilter", urlPatterns = {"/sayHello"})
public class FirstFilter implements Filter {



    //Метод init вызывается прежде, чем фильтр начинает работать, и определяет конфигурационные параметры фильтра.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
        System.out.println("LogFilter init!");
    }
    //Метод doFilter выполняет непосредственно работу фильтра
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = ((HttpServletRequest) servletRequest).getParameter("username");


        if(username != null && !username.trim().isEmpty()){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            servletRequest.setAttribute("errMsg","Name is empty!");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("valError.jsp");
            rd.include(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
        System.out.println("LogFilter destroy!");
    }
}
