package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems = new ArrayList<>();
    private double orderSubtotal;

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public Order() {

    }

    public Order(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public double getOrderSubtotal() {
        return orderSubtotal;
    }  
    
}
