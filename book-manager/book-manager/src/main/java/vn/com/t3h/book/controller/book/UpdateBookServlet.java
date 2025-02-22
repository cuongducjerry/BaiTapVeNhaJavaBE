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
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/update-book")
public class UpdateBookServlet extends HttpServlet {
    private ProductService productService;
    private ProductDao productDao = new ProductDaoImpl();

    public UpdateBookServlet() {
        productService = new ProductServiceImpl(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = (ProductModel) req.getSession().getAttribute("productModel");
        productModel.setName(req.getParameter("name"));
        productModel.setPrice(Double.parseDouble(req.getParameter("price")));
        productModel.setDiscount(Double.parseDouble(req.getParameter("discount")));
        productModel.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        productModel.setTotalBuy(Integer.parseInt(req.getParameter("totalBuy")));
        productModel.setPages(Integer.parseInt(req.getParameter("pages")));
        productModel.setPublisher(req.getParameter("publisher"));
        productModel.setYearPublishing(req.getParameter("yearPublishing"));
        productModel.setDescription(req.getParameter("description"));
        productModel.setImageName(req.getParameter("imageName"));
        productModel.setShop(Integer.parseInt(req.getParameter("shop")));

        productService.updateProduct(productModel);
        List<ProductModel> listProducts = productService.getListProducts();
        req.setAttribute("listProducts", listProducts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/books.jsp");
        requestDispatcher.forward(req, resp);

    }
}
