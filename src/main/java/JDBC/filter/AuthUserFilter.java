//package JDBC.filter;
//
//
//import JDBC.models.SessionParams;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
//@WebFilter(value = {"/user"})
//public class AuthUserFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        SessionParams sessionValues = FilterHelper.getSessionValues(servletRequest);
//        if (sessionValues.userId != null || sessionValues.userRole != null){
//            filterChain.doFilter(servletRequest,servletResponse);
//        } else {
//            response.sendRedirect("login.jsp");
//        }
//    }
//}

