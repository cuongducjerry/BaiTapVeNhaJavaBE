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

@WebServlet(urlPatterns = "/add-order-temp")
public class AddOrderTempServlet extends HttpServlet {
    private ProductService productService;
    private OrderService orderService;
    private UserService userService;

    private ProductDao productDao = new ProductDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public AddOrderTempServlet() {
        productService = new ProductServiceImpl(productDao);
        orderService = new OrderServiceImpl(orderDao);
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCustomer = req.getParameter("id2");
        List<OrderTemp> orderTempsAll = orderService.listOrderTemp();
        List<OrderTemp> orderTemps = new ArrayList<OrderTemp>();
        for(OrderTemp orderTempSub : orderTempsAll) {
            if(orderTempSub.getCustomerId() == Integer.parseInt(idCustomer)) {
                orderTemps.add(orderTempSub);
            }
        }
        req.setAttribute("orderTemps", orderTemps);
        req.setAttribute("id2", idCustomer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("order-detail.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("id");
        String idCustomer = req.getParameter("id2");
        String quantity = req.getParameter("quantity");
        System.out.println(quantity);
        UserModel userModel = userService.findUserById(Integer.parseInt(idCustomer));
        ProductModel productModel = productService.findProductById(Integer.parseInt(idProduct));
        OrderTemp orderTemp = new OrderTemp();
        orderTemp.setName(productModel.getName());
        orderTemp.setPrice(productModel.getPrice());
        orderTemp.setQuantity(Integer.parseInt(quantity));
        orderTemp.setCustomerId(Integer.parseInt(idCustomer));

        orderService.addOrderIdTemp(orderTemp);
        List<OrderTemp> orderTempsAll = orderService.listOrderTemp();
        List<OrderTemp> orderTemps = new ArrayList<OrderTemp>();
        for(OrderTemp orderTempSub : orderTempsAll) {
            if(orderTempSub.getCustomerId() == Integer.parseInt(idCustomer)) {
                orderTemps.add(orderTempSub);
            }
        }
        req.setAttribute("orderTemps", orderTemps);
        req.setAttribute("id2", idCustomer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("order-detail.jsp");
        requestDispatcher.forward(req, resp);
    }
}
