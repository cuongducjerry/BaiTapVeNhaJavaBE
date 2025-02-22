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

@WebServlet(urlPatterns = "/delete-book-employee")
public class DeleteBookEmployeeServlet extends HttpServlet {
    private ProductService productService;
    private ProductEmployeeService productEmployeeService;

    private ProductDao productDao = new ProductDaoImpl();
    private ProductEmployeeDao productEmployeeDao = new ProductEmployeeDaoImpl();

    public DeleteBookEmployeeServlet() {
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
        ProductModel productModel = productEmployeeService.findProductEmployeeById(Integer.parseInt(req.getParameter("id")));
        productService.deleteProductById(productModel.getId());
        productEmployeeService.deleteProductEmployee(productModel.getId());
        List<ProductModel> listProductEmployees = productEmployeeService.listProductEmployee();
        req.setAttribute("listProductEmployees", listProductEmployees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dms/books-role-employee.jsp");
        requestDispatcher.forward(req, resp);

    }
}
