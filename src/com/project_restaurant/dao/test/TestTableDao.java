package com.project_restaurant.dao.test;

import com.project_restaurant.dao.TableDao;
import com.project_restaurant.dao.impl.TableDaoImpl;
import com.project_restaurant.dao.utils.HibernateUtils;
import com.project_restaurant.dao.utils.TestUtil;
import com.project_restaurant.entity.Table;
import com.project_restaurant.entity.TableStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


/**
 * Created by xuero on 2017/7/27.
 * you have to reconfigure the applicationContext.xml before use this test
 * set:
 *          <tx:advice id="txAdvice" transaction-manager="txManager">
 *               <tx:attributes>
 *                  <tx:method name="*" read-only="false" propagation="REQUIRED"/>
 *               </tx:attributes>
 *           </tx:advice>
 *            <aop:config>
 *               <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.project_restaurant.dao..*.*(..))"></aop:advisor>
 *           </aop:config>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestTableDao {
    @Autowired
    TableDao tableDao = new TableDaoImpl();

    @Test
    public void testSave(){
        Table table = new Table(1, "steve", TableStatus.IDLE, null, 6);
        tableDao.save(table);
    }

    @Test
    public void testUpdate(){
        Table table = new Table(1, "aaaaa", TableStatus.RESEVERED, new Date(), 12);
        tableDao.update(table);
    }

    @Test
    public void testDelete(){
        tableDao.delete(1);
    }

    @Test
    public void testGet(){
        Table table = tableDao.get(2);
        System.out.println(table);
    }

    @Test
    public void testGetAll(){
        List<Table> all = tableDao.getAll();
        TestUtil.printList(all);
        System.out.println("---------------------------------------");
        List<Table> all1 = tableDao.getAll(1, 10);
        TestUtil.printList(all1);
    }

    @Test
    public void testGetAllByCondition(){
        Table table = new Table();
        table.setStatus(TableStatus.RESEVERED);
        List<Table> allByCondition = tableDao.getALLByCondition(table, 0, 2);
        TestUtil.printList(allByCondition);
    }

    @Test
    public void testGetAllByConditionWithFuzzy(){
        Table table = new Table();
        table.setName("ar");

        table.setStatus(TableStatus.IDLE);
        List<Table> name = tableDao.getALLByCondition(table, "name");
        TestUtil.printList(name);
    }



    @Test
    public void createDummyTable() {

        Table[] tables = new Table[10];

         tables[0] = new Table(1,"charlie", TableStatus.IDLE,null,5);
         tables[1] = new Table(1,"gwen", TableStatus.IDLE,null,6);
         tables[2] = new Table(1,"jared", TableStatus.RESEVERED,new Date(),3);
         tables[3] = new Table(1,"madison", TableStatus.IDLE,null,15);
         tables[4] = new Table(1,"eva", TableStatus.IDLE,null,2);
         tables[5] = new Table(1,"shannon", TableStatus.RESEVERED,new Date(),5);
         tables[6] = new Table(1,"steve", TableStatus.IDLE,null,6);
         tables[7] = new Table(1,"jamie", TableStatus.RESEVERED,new Date(),2);
         tables[8] = new Table(1,"laura", TableStatus.IDLE,null,5);
         tables[9] = new Table(1,"jill", TableStatus.IDLE,null,10);

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        for (int i=0; i<tables.length;i++){
            session.save(tables[i]);
        }


        transaction.commit();
        HibernateUtils.close(session);
    }
}
