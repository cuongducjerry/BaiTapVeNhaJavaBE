package vn.com.t3h.book.service.impl;

import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductModel> getListProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public int addProduct(ProductModel product) {
        return productDao.addProduct(product);
    }

    @Override
    public ProductModel findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    @Override
    public int updateProduct(ProductModel product) {
        return productDao.updateProduct(product);
    }

    @Override
    public int deleteProductById(Integer id) {
        return productDao.deleteProduct(id);
    }


}
