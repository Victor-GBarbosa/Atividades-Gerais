package entities;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public void increaseSalary(Double x) {
        this.salary = this.salary + (this.salary * x/100);
    }

    //Constructor

    public void showInfo() {
        System.out.println("\nName: " + this.name + "\nSalary: " + this.salary + "\nID: " + this.id + "\n");
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //Getters

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

}
