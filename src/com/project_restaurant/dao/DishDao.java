package com.project_restaurant.dao;

import com.project_restaurant.entity.Dish;

import java.util.List;

/**
 * Created by xuero on 2017/7/27.
 */
public interface DishDao {
    void save(Dish dish);
    void update(Dish dish);
    void delete(Integer dishId);
    Dish get(Integer dishId);
    Dish getWithOrderSet(Integer dishId);
    //without order set
    List<Dish> getAll();
    List<Dish> getAll(int firstResult, int maxResult);
    //with order set
    List<Dish> getAllWithOrderSet();
    List<Dish> getALLByCondition(Dish dish);
    List<Dish> getALLByCondition(Dish dish,int firstResult, int maxResult);
    //according fuzzyProperty do search
    List<Dish> getALLByCondition(Dish dish, String... fuzzyProperty);
}
