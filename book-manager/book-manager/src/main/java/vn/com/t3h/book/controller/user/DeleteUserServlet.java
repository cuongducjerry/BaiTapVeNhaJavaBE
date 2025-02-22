package vn.com.t3h.book.controller.user;

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
import java.util.List;

@WebServlet(urlPatterns = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public DeleteUserServlet() {
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = userService.findUserById(Integer.parseInt(req.getParameter("id")));
        userService.deleteUserById(Integer.parseInt(req.getParameter("id")));
        List<UserModel> listUsers = userService.getAllUsers();
        req.setAttribute("listUsers", listUsers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
