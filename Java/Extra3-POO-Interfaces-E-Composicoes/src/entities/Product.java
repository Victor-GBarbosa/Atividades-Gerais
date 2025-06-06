package entities;

public class Product {
    protected String name;
    protected double price;
    public String getName() {
        return name;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return name + String.format(" R$%.2f", price);
    }
}


