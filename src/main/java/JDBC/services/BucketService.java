package JDBC.services;
import JDBC.entiti.Product;

import java.sql.SQLException;
import java.util.*;
public interface BucketService {
    List<Product> getProducts(int bucketId) throws SQLException;
    void addProduct(int bucketId, int productId) throws SQLException;
    void removeProduct(int bucketId, int productId) throws SQLException;
}
