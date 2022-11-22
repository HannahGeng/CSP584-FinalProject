package com.iit.dao;

import com.iit.bean.OrderItem;

public interface OrderItemDao {
    void insertOrderItem(OrderItem orderItem) throws Exception;
}
