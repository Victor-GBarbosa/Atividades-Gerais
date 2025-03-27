package entities;

import java.util.Date;
import java.util.Scanner;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    Scanner scan = new Scanner(System.in);

    public void clientRegister() {
        System.out.print("\nInsira o email do cliente: ");
        this.email = scan.nextLine();
    }
}


