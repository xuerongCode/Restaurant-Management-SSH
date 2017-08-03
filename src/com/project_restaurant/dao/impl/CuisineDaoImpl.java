package com.project_restaurant.dao.impl;

import com.project_restaurant.dao.CuisineDao;
import com.project_restaurant.dao.utils.CollectionUtils;
import com.project_restaurant.dao.utils.StringUtil;
import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.entity.Dish;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuero on 2017/8/1.
 */
public class CuisineDaoImpl extends HibernateDaoSupport implements CuisineDao {
    @Override
    public void save(Cuisine cuisine) {
        this.getHibernateTemplate().save(cuisine);
    }

    @Override
    public void update(Cuisine cuisine) {
        this.getHibernateTemplate().update(cuisine);
    }

    @Override
    public void delete(Integer cuisineId) {
        Cuisine cuisine = this.getSessionFactory().getCurrentSession().get(Cuisine.class, cuisineId);
        this.getSessionFactory().getCurrentSession().delete(cuisine);
    }

    @Override
    public Cuisine get(Integer cuisineId) {
        return this.getHibernateTemplate().get(Cuisine.class, cuisineId);
    }

    @Override
    public Cuisine getWithDishSet(Integer cuisineId) {
        List<?> objects = this.getHibernateTemplate().find("from com.project_restaurant.entity.Cuisine c left join fetch  c.dishSet where c.id=?",cuisineId);
        return (Cuisine) objects.get(0);
    }

    @Override
    public List<Cuisine> getAll() {
        return this.getHibernateTemplate().findByExample(new Cuisine());
    }

    @Override
    public List<Cuisine> getAll(int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(new Cuisine(),firstResult,maxResult);
    }


    @Override
    public List<Cuisine> getAllByCondition(Cuisine cuisine) {
        return this.getHibernateTemplate().findByExample(cuisine);
    }

    @Override
    public List<Cuisine> getAllByCondition(Cuisine cuisine, int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(cuisine,firstResult,maxResult);
    }

    @Override
    public List<Cuisine> getAllByCondition(Cuisine cuisine, String... fuzzyProperty) {
        String sql = "from com.project_restaurant.entity.Cuisine where 1=1 ";
        Map<String,Object> map = new HashMap<String,Object>();
        Class<Cuisine> clazz = (Class<Cuisine>) cuisine.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            try {
                String name = f.getName();
                f.setAccessible(true);
                Object o = null;
                o = f.get(cuisine);
                if(o != null && !CollectionUtils.isCollection(o)) {
                    if(o instanceof String  && StringUtil.isStringArrayContain(fuzzyProperty,name)){
                        sql = sql + "and " + name + " like :" + name + " ";
                        map.put(name,o);
                    }else {
                        sql = sql + "and " + name + "= :" + name + " ";
                        map.put(name,o);
                    }

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Object[] objects = new Object[map.size()];
        String[] strings = new String[map.size()];
        int i=0;

        for (Map.Entry<String, Object> m : map.entrySet()) {
            if(m.getValue() instanceof String && StringUtil.isStringArrayContain(fuzzyProperty,m.getKey())) {
                strings[i] = m.getKey();
                objects[i] = "%"+(String)m.getValue()+"%";
            }else {
                strings[i] = m.getKey();
                objects[i] = m.getValue();
            }
            i++;
        }
        return (List<Cuisine>) this.getHibernateTemplate().findByNamedParam(sql,strings,objects);
    }
}
