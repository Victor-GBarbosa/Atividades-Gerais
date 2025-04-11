package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected double chargedAmount;
    protected double subTotal = 0.00;
    protected int id;

    Client client;
    List<OrderProduct> orderProducts = new ArrayList<>();


    public Order(int id, Client client) {
        this.id = id;
        this.client = client;
    }
    public double getSubtotal() {
        for (int i = 0; i < orderProducts.size(); i++) {
            this.subTotal += orderProducts.get(i).getTotalValue();
        }
        return subTotal;
    }

    public void setChargedAmount(double chargedAmount) {
        this.chargedAmount = chargedAmount;
    }
    public void addOrderProduct(OrderProduct orderProduct) {
        this.orderProducts.add(orderProduct);

    }

    public int getId() {
        return id;
    }
    public Client getClient() {
        return client;
    }
}
