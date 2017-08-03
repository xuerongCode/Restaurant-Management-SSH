package com.project_restaurant.dao.impl;

import com.project_restaurant.dao.DishDao;
import com.project_restaurant.entity.Dish;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuero on 2017/8/1.
 */
public class DishDaoImpl extends HibernateDaoSupport implements DishDao {
    @Override
    public void save(Dish dish) {
        this.getHibernateTemplate().save(dish);
    }

    @Override
    public void update(Dish dish) {
        this.getHibernateTemplate().update(dish);
    }

    @Override
    public void delete(Integer dishId) {
        Dish dish = this.getSessionFactory().getCurrentSession().get(Dish.class, dishId);
        this.getSessionFactory().getCurrentSession().delete(dish);
    }

    @Override
    public Dish get(Integer dishId) {
        return this.getHibernateTemplate().get(Dish.class,dishId);
    }

    @Override
    public Dish getWithOrderSet(Integer dishId) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return this.getHibernateTemplate().findByExample(new Dish());
    }

    @Override
    public List<Dish> getAll(int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(new Dish(),firstResult,maxResult);
    }

    @Override
    public List<Dish> getAllWithOrderSet() {
        return null;
    }

    /**
     * only filter by dish
     * @param dish
     * @return
     */
    @Override
    public List<Dish> getALLByCondition(Dish dish) {
        return this.getHibernateTemplate().findByExample(dish);
    }

    @Override
    public List<Dish> getALLByCondition(Dish dish, int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(dish,firstResult,maxResult);
    }

    @Override
    public List<Dish> getALLByCondition(Dish dish, String... fuzzyProperty) {
        String sql = "from com.project_restaurant.entity.Dish as dish left join fetch dish.cuisine as cuisine where 1=1 ";
        Class<? extends Dish> c = dish.getClass();
        Field field = null;
        Object o = null;
        Map<String,Object> map = new HashMap<String,Object>();
        for (String s: fuzzyProperty){
            try {
                field = c.getDeclaredField(s);
                field.setAccessible(true);
                o = field.get(dish);
                if(o != null) {
                    if(o instanceof String){
                        sql = sql + "and dish." + s + " like :" + s + " ";
                        map.put(s,o);
                    }else {
                        sql = sql + "and dish." + s + " = :" + s + " ";
                        map.put(s,o);
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                System.out.println(s + ": no this field");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Object[] objects = new Object[map.size()];
        String[] strings = new String[map.size()];
        int i=0;

        for (Map.Entry<String, Object> m : map.entrySet()) {
            if(m.getValue() instanceof String ) {
                strings[i] = m.getKey();
                objects[i] = "%"+(String)m.getValue()+"%";
            }else {
                strings[i] = m.getKey();
                objects[i] = m.getValue();
            }
            i++;
        }
        return (List<Dish>) this.getHibernateTemplate().findByNamedParam(sql,strings,objects);
    }
}
