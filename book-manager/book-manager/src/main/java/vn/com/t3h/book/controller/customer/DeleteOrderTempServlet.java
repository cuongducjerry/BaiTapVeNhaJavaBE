package vn.com.t3h.book.controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.OrderDao;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.OrderDaoImpl;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.OrderTemp;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.OrderService;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.OrderServiceImpl;
import vn.com.t3h.book.service.impl.ProductServiceImpl;
import vn.com.t3h.book.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/delete-order-temp")
public class DeleteOrderTempServlet extends HttpServlet {

    private OrderService orderService;

    private OrderDao orderDao = new OrderDaoImpl();

    public DeleteOrderTempServlet() {
        orderService = new OrderServiceImpl(orderDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idOrder = req.getParameter("id");
        String idCustomer = req.getParameter("id2");
        orderService.deleteByOrderIdTemp(Integer.parseInt(idOrder));

        List<OrderTemp> orderTemps = orderService.listOrderTemp();

        req.setAttribute("orderTemps", orderTemps);
        req.setAttribute("id2", idCustomer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("order-detail.jsp");
        requestDispatcher.forward(req, resp);

    }
}
