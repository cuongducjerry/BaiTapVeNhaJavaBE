package vn.com.t3h.book.controller.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.ProductServiceImpl;
import vn.com.t3h.book.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/cms/users")
public class UserServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public UserServlet() {
        userService = new UserServiceImpl(userDao);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserModel> listUserModel = userService.getAllUsers();
        request.setAttribute("listUsers", listUserModel);
        request.getRequestDispatcher("/cms/users.jsp").forward(request, response);
    }

}