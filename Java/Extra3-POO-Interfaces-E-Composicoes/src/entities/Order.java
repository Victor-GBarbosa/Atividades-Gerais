package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected double chargedAmount;
    protected double subTotal = 0.00;
    protected int id;
    List<OrderProduct> orderProducts = new ArrayList<>();




    public Order(int id) {
        this.id = id;
    }
    public double setSubtotal() {
        for (int i = 0; i < orderProducts.size(); i++) {
            this.subTotal += orderProducts.get(i).getTotalValue();
        }
        return subTotal;
    }

    public double getSubTotal() {
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

    public void showOrders() {
        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.showOrderProducts();
        }
        System.out.println();
        System.out.println("Subtotal: R$" + String.format("%.2f", subTotal));
        System.out.println("Total: R$" + String.format("%.2f", chargedAmount));
        System.out.println();
    }
}
