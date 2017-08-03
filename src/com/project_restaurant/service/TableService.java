package com.project_restaurant.service;

import com.project_restaurant.entity.Table;

import java.util.Date;
import java.util.List;

/**
 * Created by xuero on 2017/7/31.
 */
public interface TableService {
    void register(Table table);
    Table getTableById(Integer tableId);
    List<Table> getAllTables();
    List<Table> getTablesByName(String name);
    void deleteTable(Integer tableId);
    void cancelReservedTable(Integer tableId);
    void reserveTable(Integer tableId, Date date);
}
