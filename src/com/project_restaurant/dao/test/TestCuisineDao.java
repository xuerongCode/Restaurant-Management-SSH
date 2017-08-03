package com.project_restaurant.dao.test;

import com.project_restaurant.dao.CuisineDao;
import com.project_restaurant.dao.utils.HibernateUtils;
import com.project_restaurant.dao.utils.TestUtil;
import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.entity.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by xuero on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCuisineDao {

    @Autowired
    CuisineDao cuisineDao;

    @Test
    public void testSave(){

        Cuisine cuisine = new Cuisine(null, "British");
        Dish dish = new Dish(null, "fdsa BBQ medley", cuisine, 23.0, 20.5, null, null);
        cuisine.getDishSet().add(dish);
        cuisineDao.save(cuisine);
    }

    @Test
    public void testUpdate(){
        Cuisine cuisine = new Cuisine(11, "bbbb");
        cuisineDao.update(cuisine);
    }

    @Test
    public void testDelete() {
        cuisineDao.delete(7);
    }

    @Test
    public void testGet(){
        Cuisine cuisine = cuisineDao.getWithDishSet(3);
        System.out.println(cuisine);
        System.out.println(cuisine.getDishSet());
    }

    @Test
    public void testGetAll(){
        List<Cuisine> all = cuisineDao.getAll();
        TestUtil.printList(all);
    }

    @Test
    public void testGetAllByCondition(){
        Cuisine cuisine = new Cuisine(2, "British");
        List<Cuisine> allByCondition = cuisineDao.getAllByCondition(cuisine,0,4);
        TestUtil.printList(allByCondition);
    }

    @Test
    public void testGetAllByConditionWithFuzzy(){
        Cuisine cuisine = new Cuisine();
        cuisine.setId(2);
        cuisine.setName("is");
        List<Cuisine> allByCondition = cuisineDao.getAllByCondition(cuisine,"name");
        TestUtil.printList(allByCondition);
    }


    @Test
    public void createDummyCuisineType() {
        Cuisine[] cuisines = new Cuisine[10];
        cuisines[0] = new Cuisine(1,"American");
        cuisines[1] = new Cuisine(1,"British");
        cuisines[2] = new Cuisine(1,"Caribbean");
        cuisines[3] = new Cuisine(1,"Chinese");
        cuisines[4] = new Cuisine(1,"French");
        cuisines[5] = new Cuisine(1,"Greek");
        cuisines[6] = new Cuisine(1,"Indian");
        cuisines[7] = new Cuisine(1,"Italian");
        cuisines[8] = new Cuisine(1,"Japanese");
        cuisines[9] = new Cuisine(1,"Mediterranean");


        for (int i=0; i<cuisines.length;i++) {
            cuisineDao.save(cuisines[i]);
        }

    }


}
