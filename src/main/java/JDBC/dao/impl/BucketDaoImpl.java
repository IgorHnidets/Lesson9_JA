package JDBC.dao.impl;

import JDBC.connections.mySQLConnector;
import JDBC.dao.BucketDao;
import JDBC.entiti.Product;
import JDBC.mappers.ProductMapper;

import java.sql.*;
import java.util.List;

public class BucketDaoImpl implements BucketDao {

    private final Connection connection;

    public BucketDaoImpl() {
        this.connection = mySQLConnector.getConnection();
    }


    @Override
    public void create(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bucket VALUES (?,?)");
        statement.setInt(1,id);
        statement.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
        statement.execute();
        statement.close();
    }

    @Override
    public List<Product> getAllProducts(int bucketId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT  * FROM bucket_product bp INNER JOIN product p on bp.product_id = p.id WHERE bp.bucket_id = ?");
        statement.setInt(1,bucketId);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = ProductMapper.mapProductsFromResultSet(resultSet);
        statement.close();
        return products;
    }

    @Override
    public void insertProduct(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO bucket_product VALUES (?,?)");
        statement.setInt(1,bucketId);
        statement.setInt(2,productId);
        statement.execute();
        statement.close();

    }

    @Override
    public void removeProduct(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE from bucket_product WHERE product_id = ? AND bucket_id = ?");
        statement.setInt(1,bucketId);
        statement.setInt(2,productId);
        statement.execute();
        statement.close();
    }
}
