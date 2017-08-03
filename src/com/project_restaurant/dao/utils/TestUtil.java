package com.project_restaurant.dao.utils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by xuero on 2017/8/1.
 */
public class TestUtil {
    public static void printList(List list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
