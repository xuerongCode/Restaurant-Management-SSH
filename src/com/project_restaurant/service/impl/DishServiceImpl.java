package com.project_restaurant.service.impl;

import com.project_restaurant.dao.DishDao;
import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.entity.Dish;
import com.project_restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by xuero on 2017/8/2.
 */
public class DishServiceImpl implements DishService {

    DishDao dishDao;


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }


    @Override
    public void registerDish(Dish dish) {
        dishDao.save(dish);
    }

    @Override
    public void updateDish(Dish dish, Integer cuisineId) {
        dish.setCuisine(new Cuisine(cuisineId));
        dishDao.update(dish);
    }

    @Override
    public Dish getDishById(Integer dishId) {
        return this.dishDao.get(dishId);
    }

    @Override
    public List<Dish> getAllDishes() {
        return this.dishDao.getAll();
    }

    @Override
    public List<Dish> getDishesByName(String dishName) {
        Dish dish = new Dish();
        dish.setName(dishName);
        return this.dishDao.getALLByCondition(dish,"name");
    }

    @Override
    public void deleteDish(Integer dishId) {
        dishDao.delete(dishId);
    }
}
