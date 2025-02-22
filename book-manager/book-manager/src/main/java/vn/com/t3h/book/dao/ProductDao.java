package vn.com.t3h.book.dao;

import vn.com.t3h.book.model.ProductModel;

import java.util.List;

public interface ProductDao {

    List<ProductModel> getAllProducts();

    int addProduct(ProductModel product);

    int deleteProduct(int productId);

    int updateProduct(ProductModel product);

    ProductModel findProductById(Integer productId);

}
