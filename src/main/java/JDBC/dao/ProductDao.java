package JDBC.dao;

import JDBC.entiti.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    void save(Product product) throws SQLException;
    List<Product> getAll() throws SQLException;
    Optional<Product> getById(int id) throws SQLException;
}
