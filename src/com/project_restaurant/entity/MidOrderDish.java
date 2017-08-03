package com.project_restaurant.entity;

import java.io.Serializable;

/**
 * Created by xuero on 2017/8/1.
 */
public class MidOrderDish implements Serializable{

    private Integer amount;
    private Order order;
    private Dish dish;

    public MidOrderDish() {
    }
    public MidOrderDish( Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "MidOrderDish{" +
                "amount=" + amount +
                '}';
    }
}
