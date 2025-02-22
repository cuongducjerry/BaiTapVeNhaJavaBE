package vn.com.t3h.book.service;

import vn.com.t3h.book.model.ProductModel;

import java.util.List;

public interface ProductEmployeeService {
    List<ProductModel> listProductEmployee();

    int addProductEmployee(ProductModel product);

    int updateProductEmployee(ProductModel product);

    int deleteProductEmployee(int id);

    ProductModel findProductEmployeeById(int idFind);

}
