package vn.com.t3h.book.controller;

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
import vn.com.t3h.book.security.AuthenticationService;
import vn.com.t3h.book.security.AuthenticationServiceImpl;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductServiceImpl;
import vn.com.t3h.book.util.SessionUtil;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {
    private AuthenticationService authenticationService;
    public LoginServlet() {
        this.authenticationService = new AuthenticationServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        req.getSession().setAttribute("message", message);
        if (req.getRequestURI().startsWith("/logout")) {
            resp.sendRedirect("/home");
            SessionUtil.removeValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String url = this.authenticationService.login(username, password,req);
        System.out.println("URL Authenticated user: " + url);
        resp.sendRedirect(url);
    }
}
