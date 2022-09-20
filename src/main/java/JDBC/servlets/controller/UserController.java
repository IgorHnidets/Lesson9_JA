package JDBC.servlets.controller;

import JDBC.dao.impl.UserDaoImpl;
import JDBC.dto.UserDTO;
import JDBC.entiti.User;
import JDBC.exceptions.UserNotFoundException;
import JDBC.services.UserService;
import JDBC.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private final UserService userService;

    public UserController() {
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userId = session.getAttribute("userId");
        if (userId == null){
            resp.sendRedirect("login.jsp");
        }

        try {
            User user = userService.getById((Integer) userId);
            req.setAttribute("user",new UserDTO(user));
            req.getRequestDispatcher("cabinet.jsp").forward(req,resp);
        } catch (UserNotFoundException e) {
            resp.sendRedirect("login.jsp");
            e.printStackTrace();
        } catch (SQLException e) {
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
