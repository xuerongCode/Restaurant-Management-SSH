package com.project_restaurant.service.impl;

import com.project_restaurant.dao.OrderDao;
import com.project_restaurant.entity.Order;
import com.project_restaurant.service.OrderService;

import java.util.List;

/**
 * Created by xuero on 2017/8/3.
 */
public class OrderServiceImpl implements OrderService {

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    private OrderDao orderDao;

    @Override
    public void registerOrder(Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(Integer orderId) {

    }

    @Override
    public Order getOrderById(Integer orderId) {
        return null;
    }

    @Override
    public Order getOrderWithDishById(Integer orderId) {
        return orderDao.getWithDish(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }
}
