package vn.com.t3h.book.service.impl;

import vn.com.t3h.book.dao.OrderedListDao;
import vn.com.t3h.book.model.OrderedModel;
import vn.com.t3h.book.service.OrderedListService;

import java.util.List;

public class OrderedListServiceImpl implements OrderedListService {

    private OrderedListDao orderedListDao;

    public OrderedListServiceImpl(OrderedListDao orderedListDao) {
        this.orderedListDao = orderedListDao;
    }

    @Override
    public List<OrderedModel> listOrderedList() {
        return orderedListDao.listOrderedList();
    }

    @Override
    public int addOrderedList(OrderedModel orderedModel) {
        return orderedListDao.addOrderedList(orderedModel);
    }
}
