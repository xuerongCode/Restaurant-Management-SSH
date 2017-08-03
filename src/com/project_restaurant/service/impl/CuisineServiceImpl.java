package com.project_restaurant.service.impl;

import com.project_restaurant.dao.CuisineDao;
import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.service.CuisineService;

import java.util.List;

/**
 * Created by xuero on 2017/8/2.
 */
public class CuisineServiceImpl implements CuisineService {

    private CuisineDao cuisineDao;

    public void setCuisineDao(CuisineDao cuisineDao) {
        this.cuisineDao = cuisineDao;
    }


    @Override
    public void registerCuisine(Cuisine cuisine) {
        this.cuisineDao.save(cuisine);
    }

    @Override
    public Cuisine getCuisineById(Integer cuisineId) {
        return this.cuisineDao.get(cuisineId);
    }

    @Override
    public List<Cuisine> getCuisineByName(String cuisineName) {
        Cuisine cuisine = new Cuisine();
        cuisine.setName(cuisineName);
        return this.cuisineDao.getAllByCondition(cuisine,"name");
    }

    @Override
    public List<Cuisine> getAllCuisines() {
        return cuisineDao.getAll();
    }

    @Override
    public void deleteCuisine(Integer cuisineId) {
        cuisineDao.delete(cuisineId);
    }

    @Override
    public void updateCuisine(Cuisine cuisine) {
        this.cuisineDao.update(cuisine);
    }
}
