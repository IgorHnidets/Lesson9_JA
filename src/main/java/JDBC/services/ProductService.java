package JDBC.services;

import JDBC.entiti.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void save(Product product) throws SQLException;
    Product getById(int id) throws SQLException;
    List<Product> getAll();
}
