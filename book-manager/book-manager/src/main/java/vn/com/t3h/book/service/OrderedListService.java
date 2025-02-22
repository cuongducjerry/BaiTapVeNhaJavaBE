package vn.com.t3h.book.service;

import vn.com.t3h.book.model.OrderedModel;

import java.util.List;

public interface OrderedListService {
    List<OrderedModel> listOrderedList();

    int addOrderedList(OrderedModel orderedModel);
}
