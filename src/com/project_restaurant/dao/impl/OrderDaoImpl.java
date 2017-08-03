package com.project_restaurant.dao.impl;

import com.project_restaurant.dao.OrderDao;
import com.project_restaurant.entity.Dish;
import com.project_restaurant.entity.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by xuero on 2017/8/1.
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {


    @Override
    public void save(Order order) {

        this.getHibernateTemplate().save(order);
    }

    @Override
    public void update(Order order) {
       this.getSessionFactory().getCurrentSession().update(order);
    }


    @Override
    public void delete(Integer orderId) {
        Order order = this.getSessionFactory().getCurrentSession().get(Order.class, orderId);
        this.getSessionFactory().getCurrentSession().delete(order);
    }

    @Override
    public Order get(Integer orderId) {
        return this.getHibernateTemplate().get(Order.class,orderId);
    }

    @Override
    public Order getWithDish(Integer orderId) {
        String hql = "SELECT distinct oo from com.project_restaurant.entity.Order as oo left join fetch oo.midOrderDishSet as mid left join fetch mid.dish where oo.id=?";
        List<?> objects = this.getHibernateTemplate().find(hql,orderId);
        System.out.println(objects.size());
        return (Order) objects.get(0);
    }

    @Override
    public List<Order> getAll() {
        return this.getHibernateTemplate().findByExample(new Order());
    }

    @Override
    public List<Order> getAll(int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(new Order(),firstResult,maxResult);
    }

    @Override
    public List<Order> getAllWithDish() {
        return null;
    }

    @Override
    public List<Order> getAllWithDish(int firstResult, int maxResult) {
        return null;
    }

    @Override
    public List<Order> getAllWithOrderSet() {
        return null;
    }

    @Override
    public List<Order> getALLByCondition(Order order) {
        return this.getHibernateTemplate().findByExample(order);
    }

    @Override
    public List<Order> getALLByCondition(Order order, int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(order,firstResult,maxResult);
    }

    @Override
    public List<Order> getALLByCondition(Order order, String... fuzzyProperty) {
        return null;
    }
}
