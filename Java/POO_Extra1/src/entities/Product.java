package entities;

import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean occupied; 

    Scanner scan = new Scanner(System.in);
    
    public void setInfo() {
        System.out.println("Qual o nome do produto?");
        this.name = scan.nextLine();
        System.out.println("Qual sera o preço do produto?");
        this.price = scan.nextDouble();
        scan.nextLine();
        System.out.println("Quantas unidades deseja adicionar?");
        this.quantity = scan.nextInt(); scan.nextLine();
        
        this.occupied = true;
    }

    public void productRemove() {
        this.name = null;
        this.quantity = 0;
        this.price = 0.0;
        this.occupied = false;

    }

    public void getProduct() {
        System.out.println("\n");

        System.out.printf("Nome: %s\n", this.name);

        System.out.printf("Valor: %.2f\n",this.price);

        System.out.printf("Quantidade: %d\n", this.quantity);

       



    }

    public double getValue() {
        return quantity * price;
    }

    //Getters and Setters

    public String getName() {
        return name;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isOccupied() {
        return occupied;
    }
}


