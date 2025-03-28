package entities;

public class OrderItem {

    private int quantiy; 
    private double price;

    public OrderItem(int quantiy, double price) {
        this.quantiy = quantiy;
        this.price = price;
    }

    public int getQuantiy() {
        return quantiy;
    }
    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
