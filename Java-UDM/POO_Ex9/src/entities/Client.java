package entities;

import java.util.Scanner;

public class Client {
    private String name;
    private String email;
    private String birthDate;

    Scanner scan = new Scanner(System.in);

    public void clientRegister() {
        System.out.print("\nInsira o nome do cliente: ");
        this.name = scan.nextLine();
        System.out.print("\nInsira o email do cliente: ");
        this.email = scan.nextLine();
        System.out.print("\nInsira a data de nascimento do cliente: ");
        this.email = scan.nextLine();
    }

    public void ShowInfo() {
        System.out.println("\nNome: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Data de nascimento: " + this.birthDate);
    }
       
    }



