package vn.com.t3h.book.dao;

import vn.com.t3h.book.model.OrderedModel;

import java.util.List;

public interface OrderedListDao {
    List<OrderedModel> listOrderedList();

    int addOrderedList(OrderedModel orderedModel);
}
