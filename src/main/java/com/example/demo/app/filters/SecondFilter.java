package com.example.demo.app.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "FirstFilter", urlPatterns = {"/sayHello"})
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = ((HttpServletRequest) servletRequest).getParameter("username");

        if(username.matches(".*\\d+.*")){
            servletRequest.setAttribute("errMsg","Name is empty!");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("valError2.jsp");
            rd.include(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
