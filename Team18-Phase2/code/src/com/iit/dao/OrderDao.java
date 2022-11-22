package com.iit.dao;

import com.iit.bean.Order;

public interface OrderDao {
    void insertOrder(Order order) throws Exception;

    int getLastOrderID() throws Exception;

    Order getOrderById(int id) throws Exception;
}
