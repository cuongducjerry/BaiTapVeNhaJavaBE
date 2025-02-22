package vn.com.t3h.book.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.ProductServiceImpl;
import vn.com.t3h.book.util.SessionUtil;

import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    ProductDao productDao = new ProductDaoImpl();
    ProductService productService = null;

    public HomeServlet() {
        productService = new ProductServiceImpl(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy current user thông qua session, để kiểm tra xem user đã đăng nhập chưa
        UserModel currentUser = (UserModel) SessionUtil.getValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
        if (currentUser == null) {
            System.out.println("Current User is null");
        } else {
            System.out.println("Current User: " + currentUser.toString());
        }
        List<ProductModel> listProducts =  productService.getListProducts();
        req.setAttribute("listProducts", listProducts);
        req.setAttribute("currentUser", currentUser);
        req.setAttribute("message", "hello");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home-page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
