package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> orderItems = new ArrayList<>();
    private double orderSubtotal;
    
    
    public List<Item> getOrderItems() {
        return orderItems;
    }
    public double getOrderSubtotal() {
        return orderSubtotal;
    }  
    
}
