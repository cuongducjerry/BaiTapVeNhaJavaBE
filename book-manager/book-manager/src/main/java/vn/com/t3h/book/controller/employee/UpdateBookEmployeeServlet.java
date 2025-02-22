package vn.com.t3h.book.controller.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.ProductEmployeeDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.dao.impl.ProductEmployeeDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.ProductEmployeeService;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductEmployeeServiceImpl;
import vn.com.t3h.book.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/update-book-employee")
public class UpdateBookEmployeeServlet extends HttpServlet {
    private ProductService productService;
    private ProductEmployeeService productEmployeeService;

    private ProductDao productDao = new ProductDaoImpl();
    private ProductEmployeeDao productEmployeeDao = new ProductEmployeeDaoImpl();

    public UpdateBookEmployeeServlet() {
        productService = new ProductServiceImpl(productDao);
        productEmployeeService = new ProductEmployeeServiceImpl(productEmployeeDao);
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
        productEmployeeService.updateProductEmployee(productModel);
        List<ProductModel> listProductEmployees = productEmployeeService.listProductEmployee();
        req.setAttribute("listProductEmployees", listProductEmployees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dms/books-role-employee.jsp");
        requestDispatcher.forward(req, resp);

    }
}
