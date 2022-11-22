package com.iit.dao.impl;

import com.iit.bean.Order;
import com.iit.bean.Product;
import com.iit.dao.BaseDao;
import com.iit.dao.OrderDao;
import com.iit.utils.MySqlDataStoreUtilities;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public void insertOrder(Order order) throws Exception {
        String sql = "insert into `order` (username,userid," +
                "email,creditcard,deliverytype,state,city," +
                "street,mobile,orderquantity,zipcode," +
                "shipcost,pickupstore) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,order.getUserid(),order.getUsername(),order.getEmail(),order.getCreditcard(),
                order.getDeliverytype(),order.getState(), order.getCity(),order.getStreet(),
                order.getMobile(),order.getOrderquantity(),order.getZipcode(),order.getShipcost(),
                order.getPickupstore());
    }

    @Override
    public Order getOrderById(int id) throws Exception {
        Order order;
        String sql = "select * from order_item where orderid=?";
        order = getBean(Order.class,sql,id);
        return order;
    }

    @Override
    public int getLastOrderID() throws Exception {
        int result = -1;
        String sql = "select max(orderid) as lastid from `order`";
        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = conn.prepareStatement(sql).executeQuery();
        while (rs.next()) {
            result = rs.getInt(1);
        }
        return result;
    }
}
