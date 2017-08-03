package com.project_restaurant.dao.utils;

import org.junit.Test;

/**
 * Created by xuero on 2017/8/1.
 */
public class StringUtil {
    public static boolean isStringArrayContain(String[] array, String target){
        for (String s : array){
            if (s.equals(target)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        String[] strings = new String[]{"aa","11","asdf"};
        String string = "11";
        System.out.println(StringUtil.isStringArrayContain(strings,string));
    }
}
