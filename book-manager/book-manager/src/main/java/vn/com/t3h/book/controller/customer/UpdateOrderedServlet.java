package vn.com.t3h.book.controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.OrderedListDao;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.ProductEmployeeDao;
import vn.com.t3h.book.dao.impl.OrderedListDaoImpl;
import vn.com.t3h.book.dao.impl.ProductDaoImpl;
import vn.com.t3h.book.dao.impl.ProductEmployeeDaoImpl;
import vn.com.t3h.book.model.OrderedModel;
import vn.com.t3h.book.model.ProductModel;
import vn.com.t3h.book.service.OrderedListService;
import vn.com.t3h.book.service.ProductEmployeeService;
import vn.com.t3h.book.service.ProductService;
import vn.com.t3h.book.service.impl.OrderedListServiceImpl;
import vn.com.t3h.book.service.impl.ProductEmployeeServiceImpl;
import vn.com.t3h.book.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cms/list-ordered", "/dms/list-ordered"})
public class UpdateOrderedServlet extends HttpServlet {

    private OrderedListDao orderedListDao = new OrderedListDaoImpl();
    private OrderedListService orderedListService;

    public UpdateOrderedServlet() {
        orderedListService = new OrderedListServiceImpl(orderedListDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderedModel> orderedModels = orderedListService.listOrderedList();
        req.setAttribute("orderedModels", orderedModels);
        String path = req.getServletPath();
        if (path.startsWith("/cms/")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/list-ordered.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if(path.startsWith("/dms/")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dms/list-ordered.jsp");
            requestDispatcher.forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
