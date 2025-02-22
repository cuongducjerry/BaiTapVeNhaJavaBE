package vn.com.t3h.book.service;

import vn.com.t3h.book.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> getListProducts();

    int addProduct(ProductModel product);

    ProductModel findProductById(Integer id);

    int updateProduct(ProductModel product);

    int deleteProductById(Integer id);

}
