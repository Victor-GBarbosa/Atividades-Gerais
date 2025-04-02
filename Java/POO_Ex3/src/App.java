import java.util.Scanner;
import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Employee a = new Employee();
        Scanner scan = new Scanner(System.in);

        a.getInfo();
        System.out.println("em quantos porcentdo deseja aumentar o salario?");
        a. salary = a.increaseSalary(scan.nextDouble());
        a.tax();

        System.out.printf("\n\nNome: %s\nSalario bruto: %.2f\n\nImposto: %.2f\nSalario (imposto discontado): %.2f\n\n", a.name, a.grossSalary, a.tax, a.salary);

        scan.close();
    }
}
