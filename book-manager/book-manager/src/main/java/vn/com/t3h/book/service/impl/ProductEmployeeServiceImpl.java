package vn.com.t3h.book.service.impl;

import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.ProductEmployeeDao;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.ProductEmployeeService;

import java.util.List;

public class ProductEmployeeServiceImpl implements ProductEmployeeService {

    private ProductEmployeeDao productEmployeeDao;

    public ProductEmployeeServiceImpl(ProductEmployeeDao productEmployeeDao) {
        this.productEmployeeDao = productEmployeeDao;
    }

    @Override
    public List<ProductModel> listProductEmployee() {
        return productEmployeeDao.listProductEmployee();
    }

    @Override
    public int addProductEmployee(ProductModel product) {
        return productEmployeeDao.addProductEmployee(product);
    }

    @Override
    public int updateProductEmployee(ProductModel product) {
        return productEmployeeDao.updateProductEmployee(product);
    }

    @Override
    public int deleteProductEmployee(int id) {
        return productEmployeeDao.deleteProductEmployee(id);
    }

    @Override
    public ProductModel findProductEmployeeById(int idFind) {
        return productEmployeeDao.findProductEmployeeById(idFind);
    }
}
