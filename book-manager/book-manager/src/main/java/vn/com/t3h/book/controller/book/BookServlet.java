package vn.com.t3h.book.controller.book;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/cms/books")
public class BookServlet extends HttpServlet {
    private ProductService productService;
    private ProductDao productDao = new ProductDaoImpl();

    public BookServlet() {
        productService = new ProductServiceImpl(productDao);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductModel> listProductModel = productService.getListProducts();
        request.setAttribute("listProducts", listProductModel);
        request.getRequestDispatcher("/cms/books.jsp").forward(request, response);
    }

}
