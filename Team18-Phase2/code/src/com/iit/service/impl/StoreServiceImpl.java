package com.iit.service.impl;

import com.iit.bean.Store;
import com.iit.dao.StoreDao;
import com.iit.dao.impl.StoreDaoImpl;
import com.iit.service.StoreService;

import java.util.List;

public class StoreServiceImpl implements StoreService {

    StoreDao storeDao = new StoreDaoImpl();
    @Override
    public List<Store> selectStores() {
        return storeDao.getStores();
    }
}
