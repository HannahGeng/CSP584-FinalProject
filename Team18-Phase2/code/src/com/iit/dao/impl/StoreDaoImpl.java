package com.iit.dao.impl;

import com.iit.bean.Store;
import com.iit.dao.BaseDao;
import com.iit.dao.StoreDao;

import java.util.List;

public class StoreDaoImpl extends BaseDao<Store> implements StoreDao {

    @Override
    public List<Store> getStores() {
        String sql = "select * from stores";
        return getBeanList(Store.class,sql);
    }
}
