package JDBC.dao;

import JDBC.entiti.Product;

import java.sql.SQLException;
import java.util.*;

public interface BucketDao {
    void create(int id) throws SQLException;
    List<Product> getAllProducts(int id) throws SQLException;
    void insertProduct(int bucketId, int productId) throws SQLException;
    void removeProduct(int bucketId, int productId) throws SQLException;
}
