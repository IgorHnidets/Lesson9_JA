package JDBC.servlets;

import JDBC.dao.impl.UserDaoImpl;
import JDBC.entiti.User;
import JDBC.exceptions.UserAlreadyExistException;
import JDBC.services.UserService;
import JDBC.services.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;
    public RegistrationServlet() {
       userService =  new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        FOR JAVA
//        String first_name = req.getParameter("firstname");
//        String last_name = req.getParameter("lastname");
//        String email = req.getParameter("email");
//        String pass = req.getParameter("password");

//        User user = new User(firstname,lastname,email,password);
//        System.out.println(user);
//        userService.save(user);



        
//        FOR JAVASCRIPT
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        User user = gson.fromJson(reader, User.class);
        System.out.println(user);
        try {
            userService.save(user);
            resp.sendRedirect("login.jsp");
        } catch (UserAlreadyExistException e) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            e.printStackTrace();
        }


    }

}

