package com.project_restaurant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuero on 2017/7/28.
 */
public class Order implements Serializable{
    private Integer id;
    private OrderStatus status;
    private Date placedDate;
    private Date paidDate;
    private Double orderSummary;
    private Integer totalQuantity;
    private Table table;
    private Set<MidOrderDish> midOrderDishSet = new HashSet<MidOrderDish>();

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public Order(Integer id, OrderStatus status, Date placedDate, Date paidDate, Double orderSummary, Integer totalQuantity) {
        this.id = id;
        this.status = status;
        this.placedDate = placedDate;
        this.paidDate = paidDate;
        this.orderSummary = orderSummary;
        this.totalQuantity = totalQuantity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Double getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(Double orderSummary) {
        this.orderSummary = orderSummary;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Set<MidOrderDish> getMidOrderDishSet() {
        return midOrderDishSet;
    }

    public void setMidOrderDishSet(Set<MidOrderDish> midOrderDishSet) {
        this.midOrderDishSet = midOrderDishSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", placedDate=" + placedDate +
                ", paidDate=" + paidDate +
                ", orderSummary=" + orderSummary +
                ", totalQuantity=" + totalQuantity +
                '}';
    }
}
