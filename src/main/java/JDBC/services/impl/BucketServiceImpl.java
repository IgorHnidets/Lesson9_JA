package JDBC.services.impl;

import JDBC.dao.BucketDao;
import JDBC.entiti.Product;
import JDBC.services.BucketService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private final BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public List<Product> getProducts(int bucketId) {
        List<Product> allProducts = new ArrayList<>();
        try {
            allProducts = bucketDao.getAllProducts(bucketId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @Override
    public void addProduct(int bucketId, int productId) {
        try {
            bucketDao.insertProduct(bucketId,productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeProduct(int bucketId, int productId) throws SQLException {
        bucketDao.removeProduct(bucketId,productId);
    }
}
