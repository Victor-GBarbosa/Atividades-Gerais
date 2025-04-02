package entities;

import java.util.Scanner;

public class Room {

    private boolean rented = false;
    private String renter;  
    private String contact;
    private int rentHistory;
    private int number;

    Scanner scan = new Scanner(System.in);


    
    
    public int getRentHistory() {
        return rentHistory;
    }

    public Room(String renter, String contact, int number) {
        this.renter = renter;
        this.contact = contact;
        this.number = number;
    }

    //Getters
    public boolean isRented() {
        return rented;
    }

    public String getRenter() {
        return renter;
    }

    public String getContact() {
        return contact;
    }

    public void rent(int rentHistory) {
        System.out.println("Qual o nome do inquilino");
        this.renter = scan.nextLine();
        System.out.println("Qual o email do inquilino");
        this.contact = scan.nextLine();
        this.rented = true;
        this.rentHistory = rentHistory;
    }

    
    public void show() {
        System.out.printf("Nome %s:\nContato %s\nNumero: %d \n", this.renter, this.contact, this.number);
    
    }
}


