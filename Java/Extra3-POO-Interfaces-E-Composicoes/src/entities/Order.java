package entities;

import java.util.ArrayList;
import java.util.List;

import Interfaces.PaymentMethod;

public class Order {
    protected double totalValue;
    protected int id;

    Client client;
    List<OrderProduct> products = new ArrayList<>();


    public Order(int id, Client client) {
        this.id = id;
        this.client = client;
    }
    public double getTotalValue() {
        double tValue = 0;
        for (OrderProduct product : products) {
            tValue += product.getTotalValue();
        }
        return tValue;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        this.products.add(orderProduct);

    }

    public int getId() {
        return id;
    }
    public Client getClient() {
        return client;
    }
}
