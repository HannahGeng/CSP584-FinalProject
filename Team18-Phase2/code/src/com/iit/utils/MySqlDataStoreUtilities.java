package com.iit.utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class MySqlDataStoreUtilities {
    private static DataSource dataSource;
    static {
        try {
            InputStream is = MySqlDataStoreUtilities.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){

        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void releaseConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public HashMap<Integer, String> getAjaxData(String searchId) {
        HashMap<Integer, String> data = new HashMap<Integer, String>();
        try {
            Connection con = getConnection();
            String sql = "select productid, model from productcatalog where model like '%" + searchId
                    + "%' and type!= 'Accessory'";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                data.put(id, model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
