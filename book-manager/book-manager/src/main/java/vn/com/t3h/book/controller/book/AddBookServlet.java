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

@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {
    private ProductService productService;
    private ProductDao productDao = new ProductDaoImpl();

    public AddBookServlet() {
        productService = new ProductServiceImpl(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-book.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String pages = req.getParameter("pages");
        String publisher = req.getParameter("publisher");
        String yearPublishing = req.getParameter("yearPublishing");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String quantity = req.getParameter("quantity");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String timestamp = req.getParameter("timestamp");
        System.out.println(timestamp);

        ProductModel productModel = new ProductModel();
        productModel.setName(name);
        productModel.setPrice(Double.parseDouble(price));
        productModel.setDiscount(Double.parseDouble(discount));
        productModel.setQuantity(Integer.parseInt(quantity));
        productModel.setTotalBuy(100);
        productModel.setAuthor(author);
        productModel.setPages(Integer.parseInt(pages));
        productModel.setPublisher(publisher);
        productModel.setYearPublishing(yearPublishing);
        productModel.setDescription(description);
        productModel.setImageName("image");
        productModel.setShop(1);
        productModel.setCreatedAt("2019-01-01 00:00:00");
        productModel.setUpdatedAt(null);
        productModel.setStartsAt(null);
        productModel.setEndsAt(null);
        productModel.setCreated_by("user2");


        productService.addProduct(productModel);
        List<ProductModel> listProductModels = productService.getListProducts();
        req.setAttribute("listProducts", listProductModels);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/books.jsp");
        requestDispatcher.forward(req, resp);
    }
}
