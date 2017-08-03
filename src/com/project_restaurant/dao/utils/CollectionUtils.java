package com.project_restaurant.dao.utils;

import org.springframework.util.Assert;

import java.util.Collection;

/**
 * Created by xuero on 2017/7/29.
 */
public class CollectionUtils {
    public static boolean isCollection(Object object){
        Assert.notNull(object, "isCollection should not receive null");
        if(object instanceof Collection){
            return true;
        }else {
            return false;
        }
    }
}
