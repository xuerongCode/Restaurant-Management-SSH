package com.project_restaurant.service;

import com.project_restaurant.entity.Dish;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by xuero on 2017/8/2.
 */
public interface DishService {
    void registerDish(Dish dish);
    void updateDish(Dish dish, Integer CuisineId);
    Dish getDishById(Integer dishId);
    //fetch=join
    List<Dish> getAllDishes();
    List<Dish> getDishesByName(String dishName);
    void deleteDish(Integer dishId);
}
