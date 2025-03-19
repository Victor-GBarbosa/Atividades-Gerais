package entities;

import java.util.Scanner;

public class Employee {
    public String name;
    public double grossSalary;
    public double salary;
    public double tax;

    Scanner scan = new Scanner(System.in);

    public void getInfo() {
        System.out.println("Qual o nome do funcionario?");
        this.name = scan.nextLine();
        System.out.println("Qual o salario do funcionario?");
        this.grossSalary = scan.nextDouble();
        System.out.println("Quanto de imposto sera cobrado?");
        this.tax = scan.nextDouble();
    }
    
    public void tax() {
        salary = salary - (salary * (tax / 100));
    }

    public double increaseSalary (double i) {
        return grossSalary + (grossSalary * (i / 100));
    }
}
