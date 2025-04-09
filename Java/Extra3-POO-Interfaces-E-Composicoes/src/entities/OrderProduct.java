package entities;

public class OrderProduct {

    private double totalValue;
    private int quantity;
    private Product product;

    public OrderProduct(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    public double getTotalValue() {
        return totalValue;
    }
    public int getQuantity() {
        return quantity;
    }


    
}
