package entities;

import java.util.Scanner;

public class User {
    private String name;
    private double balance;
    private int accontId;

    Scanner scan = new Scanner(System.in);

    public User(String name, int accontId) {
        this.name = name;
        this.accontId = accontId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccontId() {
        return accontId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doposit() {
        double i;
        System.out.println("\n\nQuanto voce deseja adicionar a conta?");
        i = scan.nextDouble();
        balance += i;
        System.err.println("Voce depositou R$" + i + " seu saldo agora é R$" + balance);
    }

    public void withdraw() {
        double i;
        System.out.println("\n\nQanto deseja sacar?");
        balance -= 5;
        i = scan.nextDouble();
        balance -= i;
        System.err.println("Voce sacou R$" + i + " seu saldo agora é R$" + balance );

    } 

    
}
