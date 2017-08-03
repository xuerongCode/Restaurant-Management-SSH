package com.project_restaurant.service;

import com.project_restaurant.entity.Order;

import java.util.List;

/**
 * Created by xuero on 2017/8/3.
 */
public interface OrderService {
    void registerOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Integer orderId);
    Order getOrderById(Integer orderId);
    Order getOrderWithDishById(Integer orderId);
    List<Order> getAllOrders();

}
