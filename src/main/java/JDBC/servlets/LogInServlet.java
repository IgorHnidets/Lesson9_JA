package JDBC.servlets;

import JDBC.dao.impl.BucketDaoImpl;
import JDBC.dao.impl.UserDaoImpl;
import JDBC.entiti.User;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.models.UserCredentials;
import JDBC.services.UserService;
import JDBC.services.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    private final UserService userService;

    public LogInServlet(){
        userService = new UserServiceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCredentials userCredentials = new UserCredentials(req.getParameter("email"),req.getParameter("pass"));
//        System.out.println(userCredentials);


        HttpSession session = req.getSession();
        try {
            User user = userService.login(userCredentials);
            session.setAttribute("userName", user.getFirstname());
            session.setAttribute("userRole",user.getRole().name());
            session.setAttribute("userId",user.getId());
            resp.sendRedirect("user");
        } catch (IncorectCredentialException e) {
            e.printStackTrace();
//            Чогось зникають артефакти
            resp.sendRedirect("/Lesson6_war_exploded/login.jsp?err=err");
        }


    }
}
