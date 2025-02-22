package vn.com.t3h.book.controller.customer;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.OrderDao;
import vn.com.t3h.book.dao.OrderedListDao;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.OrderDaoImpl;
import vn.com.t3h.book.dao.impl.OrderedListDaoImpl;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.OrderTemp;
import vn.com.t3h.book.model.OrderedModel;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.OrderService;
import vn.com.t3h.book.service.OrderedListService;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.OrderServiceImpl;
import vn.com.t3h.book.service.impl.OrderedListServiceImpl;
import vn.com.t3h.book.service.impl.UserServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ordered-list")
public class OrderedListServlet extends HttpServlet {

    private OrderedListDao orderedListDao = new OrderedListDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();

    private OrderedListService orderedListService;
    private OrderService orderService;

    public OrderedListServlet() {
        orderService = new OrderServiceImpl(orderDao);
        orderedListService = new OrderedListServiceImpl(orderedListDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("----------ID :" + id + "----------");
        List<OrderedModel> listOrderedAll = orderedListService.listOrderedList();
        List<OrderedModel> listOrderedModels = new ArrayList<>();

        for(OrderedModel orderedModel : listOrderedAll){
            if(orderedModel.getCustomerId() == Integer.parseInt(id)){
                listOrderedModels.add(orderedModel);
            }
        }

        System.out.println("------------------------------------------");
        for(OrderedModel orderedModel : listOrderedModels){
            System.out.println(orderedModel);
        }
        System.out.println("------------------------------------------");

        request.setAttribute("listOrderedModels", listOrderedModels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-customer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<OrderTemp> orderTempAll = orderService.listOrderTemp();
        List<OrderTemp> orderTempsByIdCus = new ArrayList<>();
        List<OrderedModel> listOrderedAll = orderedListService.listOrderedList();
        List<OrderedModel> listOrderedModels = new ArrayList<>();
        for(OrderedModel orderedModel : listOrderedAll){
            if(orderedModel.getCustomerId() == Integer.parseInt(id)){
                listOrderedModels.add(orderedModel);
            }
        }

        for(OrderedModel orderedModel : listOrderedModels){
            System.out.println(orderedModel);
        }

        for(OrderTemp orderTemp : orderTempAll){
            if(orderTemp.getCustomerId() == Integer.parseInt(id)){
                orderTempsByIdCus.add(orderTemp);
            }
        }

        for(OrderTemp orderTemp1 : orderTempsByIdCus){
            LocalDate today = LocalDate.now();
            OrderedModel orderedModel = new OrderedModel();
            orderedModel.setDatePurchase(String.valueOf(today));
            orderedModel.setNameProduct(orderTemp1.getName());
            double priceCurrent = orderTemp1.getPrice() * orderTemp1.getQuantity();
            orderedModel.setPrice(priceCurrent);
            orderedModel.setStatus("Đang xử lý");
            orderedModel.setCustomerId(Integer.parseInt(id));
            orderedListService.addOrderedList(orderedModel);
            listOrderedModels.add(orderedModel);
        }
        for(OrderTemp orderTemp2 : orderTempAll){
            if(orderTemp2.getCustomerId() == Integer.parseInt(id)){
                orderService.deleteByCustomerIdTemp(Integer.parseInt(id));
            }
        }

        request.setAttribute("listOrderedModels", listOrderedModels);
        request.setAttribute("idCustomer", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-customer.jsp");
        dispatcher.forward(request, response);
    }
}
