package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {

    private Date moment;
    private OrderStatus orderStatus;

    
    public Order(Date moment, OrderStatus orderStatus) {
        this.moment = moment;
        this.orderStatus = orderStatus;
    }
    
    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}


