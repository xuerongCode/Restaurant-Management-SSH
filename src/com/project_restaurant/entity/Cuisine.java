package com.project_restaurant.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuero on 2017/7/27.
 */
public class Cuisine {
    private Integer id;
    private String name;

    private Set<Dish> dishSet = new HashSet<Dish>();

    public Cuisine() {
    }

    public Cuisine(Integer id) {
        this.id = id;
    }

    public Cuisine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cuisine(Integer id, String name, Set<Dish> dishSet) {
        this.id = id;
        this.name = name;
        this.dishSet = dishSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishSet() {
        return dishSet;
    }

    public void setDishSet(Set<Dish> dishSet) {
        this.dishSet = dishSet;
    }

    @Override
    public String toString() {
        return "Cuisine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
