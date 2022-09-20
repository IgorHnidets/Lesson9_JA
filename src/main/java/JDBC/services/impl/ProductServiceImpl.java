package JDBC.services.impl;

import JDBC.dao.ProductDao;
import JDBC.entiti.Product;
import JDBC.services.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class ProductServiceImpl implements ProductService {

    private final String DEFAULT_IMAGE = "https://cdns.iconmonstr.com/wp-content/releases/preview/2019/240/iconmonstr-product-3.png";
    public final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public void save(Product product) throws SQLException {
        String image = product.getImage();

        if (image == null){
            product.setImage(DEFAULT_IMAGE);
        }
        productDao.save(product);
    }

    @Override
    public Product getById(int id)  {
        try {
            Optional<Product> product = productDao.getById(id);

            if (product.isPresent()){
                return product.get();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        try {
            return productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
