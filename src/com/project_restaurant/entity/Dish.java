package com.project_restaurant.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuero on 2017/7/27.
 */
public class Dish implements Serializable{
    private Integer id;
    private String name;
    private Cuisine cuisine;
    private Double price;
    private Double salePrice;
    private String description;
    private String imgPath;
    private Set<MidOrderDish> midOrderDishSet = new HashSet<MidOrderDish>();
    private Table table;


    public Dish() {
    }

    public Dish(Integer id) {
        this.id = id;
    }

    public Dish(Integer id, String name, Cuisine cuisine, Double price, Double salePrice, String description, String imgPath) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        this.salePrice = salePrice;
        this.description = description;
        this.imgPath = imgPath;
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

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Set<MidOrderDish> getMidOrderDishSet() {
        return midOrderDishSet;
    }

    public void setMidOrderDishSet(Set<MidOrderDish> midOrderDishSet) {
        this.midOrderDishSet = midOrderDishSet;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
