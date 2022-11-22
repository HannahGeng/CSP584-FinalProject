package com.iit.service;

import com.iit.bean.Order;
import com.iit.bean.OrderItem;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem) throws Exception;
}
