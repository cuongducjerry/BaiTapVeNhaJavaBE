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

@WebServlet(urlPatterns = "/delete-book")
public class DeleteBookServlet extends HttpServlet {
    private ProductService productService;
    private ProductDao productDao = new ProductDaoImpl();

    public DeleteBookServlet() {
        productService = new ProductServiceImpl(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = productService.findProductById(Integer.parseInt(req.getParameter("id")));
        productService.deleteProductById(productModel.getId());
        List<ProductModel> listProducts = productService.getListProducts();
        req.setAttribute("listProducts", listProducts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/books.jsp");
        requestDispatcher.forward(req, resp);

    }
}
