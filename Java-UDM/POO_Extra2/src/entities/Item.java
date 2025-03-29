package entities;

public class Item {
    private String name;
    private double price;

    

     public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

     public Item() {
        // Construtor padrão
     }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}



