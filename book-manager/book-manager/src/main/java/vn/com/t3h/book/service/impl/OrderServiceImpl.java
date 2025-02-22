package vn.com.t3h.book.service.impl;

import vn.com.t3h.book.dao.OrderDao;
import vn.com.t3h.book.dao.ProductDao;
import vn.com.t3h.book.dao.impl.OrderDaoImpl;
import vn.com.t3h.book.model.OrderTemp;
import vn.com.t3h.book.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int deleteByOrderIdTemp(int deleteOrderIdTemp) {
        return orderDao.deleteByOrderIdTemp(deleteOrderIdTemp);
    }

    @Override
    public int addOrderIdTemp(OrderTemp addOrderIdTemp) {
        return orderDao.addOrderIdTemp(addOrderIdTemp);
    }

    @Override
    public List<OrderTemp> listOrderTemp() {
        return orderDao.listOrderTemp();
    }

    @Override
    public void deleteOrderTempAll() {
        orderDao.deleteOrderTempAll();
    }

    @Override
    public int deleteByCustomerIdTemp(int deleteCustomerIdTemp) {
        return orderDao.deleteByCustomerIdTemp(deleteCustomerIdTemp);
    }
}
