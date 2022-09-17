package JDBC.mappers;

import JDBC.entiti.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static List<Product> mapProductsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Product> resList = new ArrayList<>();

        while (resultSet.next()) {
            Product product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
            resList.add(product);
        }
        return resList;
    }

    public static Product mapProduct(ResultSet resultSet) throws SQLException {
        Product product = null;
        while (resultSet.next()) {
            product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5));
        }
        return product;
    }
}
