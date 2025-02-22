package vn.com.t3h.book.dao;

import vn.com.t3h.book.model.OrderTemp;

import java.util.List;

public interface OrderDao {
    int deleteByOrderIdTemp(int deleteOrderIdTemp);

    int addOrderIdTemp(OrderTemp addOrderIdTemp);

    List<OrderTemp> listOrderTemp();

    void deleteOrderTempAll();

    int deleteByCustomerIdTemp(int deleteCustomerIdTemp);

}
