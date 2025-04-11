package Interfaces;

import entities.Order;

public class PixPayment implements PaymentMethod {

    @Override
    public void payService(Order order) {
        order.setChargedAmount(order.getSubtotal() + (order.getSubtotal() * 0.3));
    }

}
