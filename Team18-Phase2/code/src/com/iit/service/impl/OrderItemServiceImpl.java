package com.iit.service.impl;

import com.iit.bean.OrderItem;
import com.iit.dao.OrderItemDao;
import com.iit.dao.impl.OrderItemDaoImpl;
import com.iit.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public void saveOrderItem(OrderItem orderItem) throws Exception {
        orderItemDao.insertOrderItem(orderItem);
    }
}
