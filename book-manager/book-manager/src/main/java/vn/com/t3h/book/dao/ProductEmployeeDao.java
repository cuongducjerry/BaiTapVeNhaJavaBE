package vn.com.t3h.book.dao;

import vn.com.t3h.book.model.ProductModel;

import java.util.List;

public interface ProductEmployeeDao {
    List<ProductModel> listProductEmployee();

    int addProductEmployee(ProductModel product);

    int updateProductEmployee(ProductModel product);

    int deleteProductEmployee(int id);

    ProductModel findProductEmployeeById(int idFind);

}
