package com.project_restaurant.dao;

import com.project_restaurant.entity.Order;

import java.util.List;

/**
 * Created by xuero on 2017/8/1.
 */
public interface OrderDao {
    void save(Order order);
    void update(Order order);
    void delete(Integer orderId);
    Order get(Integer orderId);
    Order getWithDish(Integer orderId);
    //without order set
    List<Order> getAll();
    List<Order> getAll(int firstResult, int maxResult);
    List<Order> getAllWithDish();
    List<Order> getAllWithDish(int firstResult, int maxResult);
    //with order set
    List<Order> getAllWithOrderSet();
    List<Order> getALLByCondition(Order order);
    List<Order> getALLByCondition(Order order,int firstResult, int maxResult);
    List<Order> getALLByCondition(Order order, String... fuzzyProperty);
}
