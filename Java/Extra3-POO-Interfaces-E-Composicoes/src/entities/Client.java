package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    protected String name;

    List<Order> orderList = new ArrayList<>();

    public void addNewOrder(Order order) {
        this.orderList.add(order);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return name;
    }
}
