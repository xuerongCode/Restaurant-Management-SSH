package com.project_restaurant.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuero on 2017/7/27.
 */
public class Table {
    private Integer id;
    private String name;
    private TableStatus status;
    private Date reserveDate;
    private Integer maxCapacity;
    private Set<Order> orderSet = new HashSet<Order>();


    public Table() {
    }

    public Table(Integer id) {
        this.id = id;
    }

    public Table(Integer id, String name, TableStatus status, Date reserveDate, Integer maxCapacity) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.reserveDate = reserveDate;
        this.maxCapacity = maxCapacity;
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

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", reserveDate=" + reserveDate +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
