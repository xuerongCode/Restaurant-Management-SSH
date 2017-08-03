package com.project_restaurant.dao.test;

import com.project_restaurant.entity.Table;
import com.project_restaurant.entity.TableStatus;
import com.project_restaurant.service.TableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xuero on 2017/7/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestApp {

    @Autowired
    private TableService tableService;

    @Test
    public void IntegrationSpring(){
        Table table = new Table(1, "charlie", TableStatus.IDLE, null, 5);
        tableService.register(table);
    }
}
