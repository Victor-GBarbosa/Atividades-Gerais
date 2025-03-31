package entities;

public class Product {
    protected String name; 
    protected double price;

    public void getInfo() {
        System.out.printf("%s - R$%.2f", this.name, this.price);
    }

    //Getters e Setters
    public String getName() {
        return name;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}
