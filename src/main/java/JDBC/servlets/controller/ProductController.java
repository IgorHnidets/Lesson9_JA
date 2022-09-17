package JDBC.servlets.controller;

import JDBC.dao.impl.ProductDaoImpl;
import JDBC.entiti.Product;
import JDBC.services.ProductService;
import JDBC.services.impl.ProductServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    private final ProductService productService;

    public ProductController() {
        this.productService = new ProductServiceImpl(new ProductDaoImpl());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        List<Product> all = productService.getAll();
        writer.print(gson.toJson(all));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        Product product = gson.fromJson(reader, Product.class);
        try {
            productService.save(product);
            resp.sendRedirect("index.jsp");
        } catch (SQLException exception){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            exception.printStackTrace();
        }
    }

}
