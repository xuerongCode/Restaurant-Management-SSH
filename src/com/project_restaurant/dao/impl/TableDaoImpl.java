package com.project_restaurant.dao.impl;

import com.project_restaurant.dao.TableDao;
import com.project_restaurant.dao.utils.StringUtil;
import com.project_restaurant.entity.Table;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuero on 2017/7/31.
 */
public class TableDaoImpl extends HibernateDaoSupport implements TableDao {

    @Override
    public void save(Table table) {
        this.getHibernateTemplate().save(table);

    }

    @Override
    public void update(Table table) {
        this.getHibernateTemplate().update(table);
    }

    @Override
    public void delete(Integer tableId) {
        this.getHibernateTemplate().delete(new Table(tableId));
    }

    @Override
    public Table get(Integer tableId) {
        return this.getHibernateTemplate().get(Table.class, tableId);

    }

    @Override
    public List<Table> getAll() {
        return  this.getHibernateTemplate().findByExample(new Table());
    }

    @Override
    public List<Table> getAll(int firstResult, int maxResult) {
        return  this.getHibernateTemplate().findByExample(new Table(),firstResult,maxResult);
    }

    @Override
    public List<Table> getALLByCondition(Table table) {
        return this.getHibernateTemplate().findByExample(table);
    }

    @Override
    public List<Table> getALLByCondition(Table table, int firstResult, int maxResult) {
        return this.getHibernateTemplate().findByExample(table,firstResult,maxResult);
    }

    @Override
    public List<Table> getALLByCondition(Table table, String... fuzzyProperty) {
        String sql = "from com.project_restaurant.entity.Table where 1=1 ";
        Map<String,Object> map = new HashMap<String,Object>();
        Class<Table> clazz = (Class<Table>) table.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            try {
                String name = f.getName();
                f.setAccessible(true);
                Object o = null;
                o = f.get(table);
                if(o != null) {
                    if(o instanceof String && StringUtil.isStringArrayContain(fuzzyProperty,name)){
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

        return (List<Table>) this.getHibernateTemplate().findByNamedParam(sql,strings,objects);
    }
}
