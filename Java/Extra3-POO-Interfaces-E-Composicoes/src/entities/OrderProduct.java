package entities;

public class OrderProduct {

    private double totalValue;
    private int quantity;
    private Product product;

    public OrderProduct(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

   public void setTotalValue() {
    this.totalValue = product.price * quantity;
}

    public double getTotalValue() {
        setTotalValue();
        return totalValue;
    }
    public int getQuantity() {
        return quantity;
    }


    
}
