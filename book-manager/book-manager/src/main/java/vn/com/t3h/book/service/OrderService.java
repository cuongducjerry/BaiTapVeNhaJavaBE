package vn.com.t3h.book.service;

import vn.com.t3h.book.model.OrderTemp;

import java.util.List;

public interface OrderService {

    int deleteByOrderIdTemp(int deleteOrderIdTemp);

    int addOrderIdTemp(OrderTemp addOrderIdTemp);

    List<OrderTemp> listOrderTemp();

    void deleteOrderTempAll();

    int deleteByCustomerIdTemp(int deleteCustomerIdTemp);

}
