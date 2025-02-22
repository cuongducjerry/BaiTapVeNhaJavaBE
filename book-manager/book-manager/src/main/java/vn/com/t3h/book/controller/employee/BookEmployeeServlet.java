package vn.com.t3h.book.controller.employee;

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

@WebServlet(urlPatterns = "/dms/books-employee")
public class BookEmployeeServlet extends HttpServlet {
    private ProductEmployeeService productEmployeeService;
    private ProductEmployeeDao productEmployeeDao = new ProductEmployeeDaoImpl();

    public BookEmployeeServlet() {
        productEmployeeService = new ProductEmployeeServiceImpl(productEmployeeDao);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductModel> listProductEmployees = productEmployeeService.listProductEmployee();
        request.setAttribute("listProductEmployees", listProductEmployees);
        request.getRequestDispatcher("/dms/books-role-employee.jsp").forward(request, response);
    }
}
