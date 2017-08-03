package com.project_restaurant.dao.test;

import com.project_restaurant.dao.DishDao;
import com.project_restaurant.dao.utils.HibernateUtils;
import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.entity.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.SourceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;


/**
 * Created by xuero on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDishDao {

    @Autowired
    private DishDao dishDao;

    @Test
    public void testSave(){
        Cuisine cuisine = new Cuisine(1);
        Dish dish = new Dish(null, "Texas BBQ medley", cuisine, 23.0, 20.5, null, null);
        dishDao.save(dish);
    }

    /**
     * can not update foreign key because update=false
     * if update=true the delete function will break
     * if update=false the cuisineId will not update foreign key
     */
    @Test
    public void testUpdate(){
        Cuisine cuisine = new Cuisine(6,"bbbbb");
        Dish dish = new Dish(2, "a3aa", cuisine, 22.0, 20.5, null, null);
        dishDao.update(dish);
    }

    /**
     * set update=false
     */
    @Test
    public void testDelete(){
        dishDao.delete(3);
    }

    /**
     * always get cuisine
     */
    @Test
    public void testGet(){
        Dish dish = dishDao.get(3);
        System.out.println(dish);
        System.out.println(dish.getCuisine());

    }

    @Test
    public void testGetAll(){
        List<Dish> all = dishDao.getAll(0,5);
        Iterator<Dish> iterator = all.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * only filter by dish
     */
    @Test
    public void testGetAllByCondition(){
        Dish dish = new Dish();
        Cuisine cuisine = new Cuisine();
        cuisine.setName("American");
        dish.setName("Texas BBQ medley");
        dish.setCuisine(cuisine);
        List<Dish> all = dishDao.getALLByCondition(dish,0,2);
        Iterator<Dish> iterator = all.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void createDummyCuisineType() {
        Cuisine[] cuisines = new Cuisine[10];
        cuisines[0] = new Cuisine(1);
        cuisines[1] = new Cuisine(2);
        cuisines[2] = new Cuisine(3);
        cuisines[3] = new Cuisine(4);
        cuisines[4] = new Cuisine(5);
        cuisines[5] = new Cuisine(6);
        cuisines[6] = new Cuisine(7);
        cuisines[7] = new Cuisine(8);
        cuisines[8] = new Cuisine(9);
        cuisines[9] = new Cuisine(9);

        Dish[] dishes = new Dish[20];
        dishes[0] = new Dish(1,"Texas BBQ medley",cuisines[0],23.0,20.5,null,null);
        dishes[1] = new Dish(1,"Choc chip pecan pie",cuisines[0],24.0,20.5,null,null);
        dishes[2] = new Dish(1,"Mini pork pies with piccalilli",cuisines[1],33.0,20.5,null,null);
        dishes[3] = new Dish(1,"Crispy topped Cumberland pie",cuisines[1],34.0,20.5,null,null);
        dishes[4] = new Dish(1,"Caribbean beef patties",cuisines[2],44.0,20.5,null,null);
        dishes[5] = new Dish(1,"Sticky jerk salmon with mango slaw",cuisines[2],45.0,20.5,null,null);
        dishes[6] = new Dish(1,"Spicy Sichuan-style prawns",cuisines[3],55.0,20.5,null,null);
        dishes[7] = new Dish(1,"Chow mein",cuisines[3],56.0,20.5,null,null);
        dishes[8] = new Dish(1,"Sautéed potatoes with bacon lardons & persillade",cuisines[4],66.0,20.5,null,null);
        dishes[9] = new Dish(1,"Summer pistou",cuisines[4],67.0,20.5,null,null);
        dishes[10] = new Dish(1,"Lamb kleftiko",cuisines[5],77.0,20.5,null,null);
        dishes[11] = new Dish(1,"Artichoke, aubergine & lamb moussaka",cuisines[5],78.0,20.5,null,null);
        dishes[12] = new Dish(1,"Creamy beetroot curry",cuisines[6],88.0,20.5,null,null);
        dishes[13] = new Dish(1,"Spiced roast side of salmon",cuisines[6],89.0,20.5,null,null);
        dishes[14] = new Dish(1,"Braised rabbit pappardelle",cuisines[7],10.0,20.5,null,null);
        dishes[15] = new Dish(1,"Affogato al caffè (Vanilla ice cream & coffee)",cuisines[7],11.0,20.5,null,null);
        dishes[16] = new Dish(1,"Japanese-style bento box",cuisines[8],5.0,20.5,null,null);
        dishes[17] = new Dish(1,"Smoked salmon & avocado sushi",cuisines[8],6.0,20.5,null,null);
        dishes[18] = new Dish(1,"Griddled chicken with quinoa Greek salad",cuisines[9],110.0,20.5,null,null);
        dishes[19] = new Dish(1,"Mediterranean potato salad",cuisines[9],115.0,20.5,null,null);



        for (int i=0; i<dishes.length;i++) {
            dishDao.save(dishes[i]);
        }
    }
}
