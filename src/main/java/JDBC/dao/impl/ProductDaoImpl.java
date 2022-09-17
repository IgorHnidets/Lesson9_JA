package JDBC.dao.impl;

import JDBC.connections.mySQLConnector;
import JDBC.dao.ProductDao;
import JDBC.entiti.Product;
import JDBC.mappers.ProductMapper;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    private final Connection connection;

    public ProductDaoImpl() {
        connection = mySQLConnector.getConnection();
    }


    @Override
    public void save(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO product(name, description, price, image) VALUES (?,?,?,?)");

        statement.setString(1,product.getName());
        statement.setString(2,product.getDescription());
        statement.setDouble(3,product.getPrice());
        statement.setString(4,product.getImage());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        List<Product> products = ProductMapper.mapProductsFromResultSet(resultSet);
        statement.close();
        return products;
    }

    @Override
    public Optional<Product> getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Product product = ProductMapper.mapProduct(resultSet);
        statement.close();
        return Optional.ofNullable(product);
    }
}
