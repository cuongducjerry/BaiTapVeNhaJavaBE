package vn.com.t3h.book.controller.employee;

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

@WebServlet(urlPatterns = "/dms/update-employee")
public class UpdateEmployeeServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public UpdateEmployeeServlet() {
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
        user.setRole("EMPLOYEE");
        userService.updateUser(user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dms/update-employee.jsp");
        requestDispatcher.forward(req, resp);

    }
}
