package JDBC.filter;

import JDBC.entiti.Role;
import JDBC.models.SessionParams;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(value = {"/createProduct.jsp"})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionParams sessionValues = FilterHelper.getSessionValues(servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("ROLE IS " + sessionValues.userRole);
        if (!sessionValues.userRole.equals("ADMIN")){
            response.setStatus(403);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
