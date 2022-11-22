package com.iit.dao.impl;

import com.iit.bean.Order;
import com.iit.bean.OrderItem;
import com.iit.dao.BaseDao;
import com.iit.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<Order> implements OrderItemDao {

    @Override
    public void insertOrderItem(OrderItem orderItem) throws Exception {
        String sql = "insert into `order_item` (orderid,pcount,amount,model,price,image,manufacturer,pcondition,discount,warranty,productid) values (?,?,?,?,?,?,?,?,?,?,?)";
        update(sql, orderItem.getOrderid(),orderItem.getCount(),orderItem.getAmount(),orderItem.getModel(),orderItem.getPrice(),
                orderItem.getImage(),orderItem.getManufacturer(), orderItem.getCondition(),orderItem.getDiscount(),orderItem.getWarranty(),orderItem.getProductid());

    }
}
