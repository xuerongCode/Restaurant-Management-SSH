package com.project_restaurant.dao;

import com.project_restaurant.entity.Table;

import java.util.List;

/**
 * Created by xuero on 2017/7/27.
 */
public interface TableDao {
    void save(Table table);
    void update(Table table);
    void delete(Integer tableId);
    Table get(Integer tableId);
    List<Table> getAll();
    List<Table> getAll(int firstResult, int maxResult);
    List<Table> getALLByCondition(Table table);
    List<Table> getALLByCondition(Table table,int firstResult, int maxResult);
    List<Table> getALLByCondition(Table table, String... fuzzyProperty);
}
