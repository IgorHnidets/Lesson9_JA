package JDBC.servlets.controller;

import JDBC.dao.impl.BucketDaoImpl;
import JDBC.entiti.Product;
import JDBC.models.BucketProduct;
import JDBC.services.BucketService;
import JDBC.services.impl.BucketServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
    private final BucketService bucketService;

    public BucketController() {
        bucketService = new BucketServiceImpl(new BucketDaoImpl());
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        HttpSession session = req.getSession();
        List<Product> products = null;
        try {
            products = bucketService.getProducts((int) session.getAttribute("userId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(products));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        BucketProduct bucketProduct = gson.fromJson(reader, BucketProduct.class);
        try {
            bucketService.addProduct(bucketProduct.bucketId, bucketProduct.productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bucketId = (int) req.getSession().getAttribute("userId");
        int productId = Integer.parseInt(req.getParameter("productId"));
        try {
            bucketService.removeProduct(bucketId,productId);
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        }
    }
}
