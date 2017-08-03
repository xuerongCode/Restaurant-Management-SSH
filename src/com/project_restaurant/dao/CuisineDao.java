package com.project_restaurant.dao;

import com.project_restaurant.entity.Cuisine;

import java.util.List;

/**
 * Created by xuero on 2017/7/27.
 */
public interface CuisineDao {
    void save(Cuisine cuisine);
    void update(Cuisine cuisine);
    void delete(Integer cuisineId);
    Cuisine get(Integer cuisineId);
    Cuisine getWithDishSet(Integer cuisineId);
    List<Cuisine> getAll();
    List<Cuisine>  getAll(int firstResult, int maxResult);
    List<Cuisine> getAllByCondition(Cuisine cuisine);
    List<Cuisine> getAllByCondition(Cuisine cuisine,int firstResult, int maxResult);
    List<Cuisine> getAllByCondition(Cuisine cuisine, String... fuzzyProperty);
}
