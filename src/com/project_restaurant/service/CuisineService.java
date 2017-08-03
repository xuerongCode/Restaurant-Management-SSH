package com.project_restaurant.service;

import com.project_restaurant.entity.Cuisine;

import java.util.List;

/**
 * Created by xuero on 2017/8/2.
 */
public interface CuisineService {
    void registerCuisine(Cuisine cuisine);
    Cuisine getCuisineById(Integer cuisineId);
    List<Cuisine> getCuisineByName(String cuisineName);
    List<Cuisine> getAllCuisines();
    void deleteCuisine(Integer cuisineId);
    void updateCuisine(Cuisine cuisine);
}
