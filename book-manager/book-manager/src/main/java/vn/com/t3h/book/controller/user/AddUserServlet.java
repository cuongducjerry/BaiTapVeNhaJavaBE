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
import vn.com.t3h.book.util.PasswordUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/add-user")
public class AddUserServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public AddUserServlet() {
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = PasswordUtils.encrypt(req.getParameter("password"));
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setFullname(fullname);
        userModel.setEmail(email);
        userModel.setPhoneNumber(phoneNumber);
        userModel.setGender(Integer.parseInt(gender));
        userModel.setAddress(address);
        userModel.setRole(role);

        userService.addUser(userModel);
        List<UserModel> listUsers = userService.getAllUsers();
        req.setAttribute("listUsers", listUsers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/users.jsp");
        requestDispatcher.forward(req, resp);

    }
}
