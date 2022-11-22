package com.iit.dao.impl;

import com.iit.bean.Accessory;
import com.iit.bean.Product;
import com.iit.dao.BaseDao;
import com.iit.dao.ProductDao;
import com.iit.utils.MySqlDataStoreUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {

    @Override
    public List<Product> selectProductByType(String type) throws SQLException {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "select * from productcatalog where type="+"'"+type+"'";
        resultData = getBeanList(Product.class,sql);

        return resultData;
    }

    @Override
    public List<Product> selectProductByManufacturer(String type, String manufacturer) throws SQLException {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "select * from productcatalog where type="+"'"+type+"'"+" and manufacturer="+"'"+manufacturer+"'";
        resultData = getBeanList(Product.class,sql);
        return resultData;
    }

    @Override
    public Product fetchProductById(int id) throws SQLException {
        Product resultProduct;
        String sql = "select * from productcatalog where productid=?";
        resultProduct = getBean(Product.class,sql,id);
        return resultProduct;
    }

    @Override
    public List<Product> selectAccessoryByProductID(Integer productId) throws Exception {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "SELECT * from productcatalog WHERE productid in (SELECT a.a_id from productcatalog as p JOIN product_accessory as a ON p.productid=a.p_id WHERE a.p_id="+productId+") LIMIT 3";
        resultData = getBeanList(Product.class,sql);
        return resultData;
    }

    @Override
    public LinkedHashMap<String, Integer> getMostSelled() {
        LinkedHashMap<String, Integer> p = new LinkedHashMap();
        String sql = "SELECT productcatalog.model, SUM(order_item.pcount) AS TotalItemsSold FROM productcatalog,order_item where productcatalog.productid=order_item.productid group by order_item.productid order by SUM(order_item.pcount) DESC limit 5";
        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = null;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                int count = rs.getInt(2);
                p.put(model, count);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public LinkedHashMap<String, Integer> getTopZip() {
        LinkedHashMap<String, Integer> p = new LinkedHashMap();
        String sql = "SELECT zipcode, SUM(orderquantity) AS TotalItemsSold FROM `order` group by zipcode ORDER BY SUM(orderquantity) DESC limit 5";

        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = null;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                int count = rs.getInt(2);
                p.put(model, count);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }
}
