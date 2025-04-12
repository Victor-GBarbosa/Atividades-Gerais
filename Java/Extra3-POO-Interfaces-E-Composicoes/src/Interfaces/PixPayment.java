package Interfaces;

import entities.Order;

public class PixPayment implements PaymentMethod {

    @Override
    public void payService(Order order) {
        order.setSubtotal();
        order.setChargedAmount(order.getSubTotal() + (order.getSubTotal() * 0.3));
    }

}
