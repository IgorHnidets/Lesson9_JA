package JDBC.filter;


import JDBC.models.SessionParams;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(value = {"/user", "/createProduct.jsp","/bucket.jsp"})
public class AuthUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        Object role = session.getAttribute("userRole");
//        SessionParams sessionValues = FilterHelper.getSessionValues(servletRequest);
        if (userId != null || role != null){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            response.sendRedirect("/Lesson6_war_exploded/login.jsp");
        }
    }
}

