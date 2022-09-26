package JDBC.filter;


import JDBC.models.SessionParams;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterHelper {
    public static SessionParams getSessionValues(ServletRequest servletRequest){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        Object role = session.getAttribute("userRole");
        SessionParams sessionParams = new SessionParams(userId.toString(), role.toString());
        return sessionParams;
    }
}
