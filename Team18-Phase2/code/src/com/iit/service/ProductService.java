package com.iit.service;
import com.iit.bean.Accessory;
import com.iit.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ProductService {

    List<Product> filterByType(String type) throws Exception;

    List<Product> filterByManufacturer(String type, String manufacturer) throws Exception;

    Product filterById(Integer id) throws Exception;

    List<Product> findAccessoryByProductID(Integer productId) throws Exception;
}
