package com.project_restaurant.service.impl;

import com.project_restaurant.dao.TableDao;
import com.project_restaurant.entity.Table;
import com.project_restaurant.entity.TableStatus;
import com.project_restaurant.service.TableService;

import java.util.Date;
import java.util.List;

/**
 * Created by xuero on 2017/7/31.
 */
public class TableServiceImpl implements TableService{

    private TableDao tableDao;

    public void setTableDao(TableDao tableDao) {
        this.tableDao = tableDao;
    }

    @Override
    public void register(Table table) {
        table.setStatus(TableStatus.IDLE);
        tableDao.save(table);
    }

    @Override
    public Table getTableById(Integer tableId) {
        return tableDao.get(tableId);
    }

    @Override
    public List<Table> getAllTables() {
        return tableDao.getAll();
    }

    @Override
    public List<Table> getTablesByName(String name) {
        Table table = new Table();
        table.setName(name);
        return tableDao.getALLByCondition(table,"name");
    }

    @Override
    public void deleteTable(Integer tableId) {
        tableDao.delete(tableId);
    }

    @Override
    public void cancelReservedTable(Integer tableId) {
        Table table = tableDao.get(tableId);
        table.setStatus(TableStatus.IDLE);
        table.setReserveDate(null);
        tableDao.update(table);
    }

    @Override
    public void reserveTable(Integer tableId, Date date) {
        if(date!=null){
            Table table = tableDao.get(tableId);
            table.setStatus(TableStatus.RESEVERED);
            table.setReserveDate(date);
            tableDao.update(table);
        }
    }


}
