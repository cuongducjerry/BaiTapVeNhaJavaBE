package vn.com.t3h.book.controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/update-customer")
public class UpdateCustomerServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public UpdateCustomerServlet() {
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = (UserModel)req.getSession().getAttribute("userModel");
        System.out.println(user);
        user.setUsername(req.getParameter("username"));
        user.setFullname(req.getParameter("fullname"));
        user.setEmail(req.getParameter("email"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setAddress(req.getParameter("address"));
        user.setRole("CUSTOMER");
        userService.updateUser(user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("update-customer.jsp");
        requestDispatcher.forward(req, resp);

    }
}
