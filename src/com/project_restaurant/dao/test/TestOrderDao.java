package com.project_restaurant.dao.test;

import com.project_restaurant.dao.OrderDao;
import com.project_restaurant.dao.utils.TestUtil;
import com.project_restaurant.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xuero on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOrderDao {

    @Autowired
    private OrderDao orderDao;

   @Test
    public void testSave(){

       Order order = new Order(null, OrderStatus.CREATED,new Date(),new Date(),221196.9,12);
       order.setTable(new Table(5));
       Dish dish1 = new Dish(6);
       Dish dish2 = new Dish(8);
       MidOrderDish midOrderDish1 = new MidOrderDish();
       MidOrderDish midOrderDish2 = new MidOrderDish();
       midOrderDish1.setAmount(13);
       midOrderDish2.setAmount(13);
       midOrderDish1.setOrder(order);
       midOrderDish1.setDish(dish1);
       midOrderDish2.setOrder(order);
       midOrderDish2.setDish(dish2);
       order.getMidOrderDishSet().add(midOrderDish1);
       order.getMidOrderDishSet().add(midOrderDish2);
       orderDao.save(order);
   }

   @Test
    public void testUpdate(){
       Order order = new Order(11, OrderStatus.DELIVERIED,new Date(),new Date(),1.1,12);
       MidOrderDish midOrderDish1 = new MidOrderDish();
       Dish dish1 = new Dish(3);
       midOrderDish1.setOrder(order);
       midOrderDish1.setDish(dish1);
       midOrderDish1.setAmount(1);
       order.getMidOrderDishSet().add(midOrderDish1);
       orderDao.update(order);
   }

   @Test
    public void testDelete(){
        orderDao.delete(10);
   }

   @Test
   public void testGet(){
       Order order = orderDao.get(9);
       System.out.println(order);
   }

   @Test
   public void testGetWithDish(){
      Order order = orderDao.getWithDish(11);
      System.out.println(order);
      System.out.println(order.getMidOrderDishSet());
      Set set = order.getMidOrderDishSet();
      Iterator iterator = set.iterator();
      while (iterator.hasNext()){
         System.out.println(((MidOrderDish)iterator.next()).getDish());
      }
   }

   @Test
    public void testGetAll() {
       List<Order> all = orderDao.getAll(1,3);
       TestUtil.printList(all);
   }

   @Test
    public void testGetAllByCondition(){
       MidOrderDish midOrderDish1 = new MidOrderDish();
       Order order = new Order();
       order.setStatus(OrderStatus.CREATED);
       Dish dish1 = new Dish(123);
       midOrderDish1.setDish(dish1);
       midOrderDish1.setOrder(order);
       order.getMidOrderDishSet().add(midOrderDish1);
       List<Order> allByCondition = orderDao.getALLByCondition(order);
       TestUtil.printList(allByCondition);
   }

}
