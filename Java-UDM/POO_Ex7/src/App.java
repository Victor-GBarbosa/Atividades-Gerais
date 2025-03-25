import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        int opt;
        
        Scanner scan = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(100, "Jose", 500));
        employeeList.add(new Employee(120, "antonia", 500));
        employeeList.add(new Employee(8, "Gabriel", 1200));

        employeeList.get(1).showInfo();
        do {
            System.out.println("Bem-Vindo ao RH o que deseja fazer?\n");
            System.out.println("1-Contrar um funcionario\n2-Demitir um funcionario\n3-Ver a lista de funcionarios\n4-Aumentar o salario de um funcionario\n5-sair\n");
            opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                    boolean availableId = true;
                    do {
                        System.out.println("Qual o nome do funcionario?");
                        String name = scan.nextLine();
                        System.out.println("Qual o salario inicial do funcionario?");
                        double salary = scan.nextDouble(); scan.nextLine();
                        System.out.println("Qual o sera o id do funcionario?");
                        int employeeId = scan.nextInt(); scan.nextLine();
                            if (employeeList.stream().anyMatch(x -> x.getId() == employeeId)) {
                                System.out.println("\nEsse ID ja esta sendo utilizado por outro funcionario.\nInsira novamente as informaçãos do funcionario usando um ID diferente\n");
                                availableId = false;
                            } else {
                                employeeList.add(new Employee(employeeId, name, salary));
                                availableId = true;
                            }
                        

                        } while (!availableId);
                        break;
                    
                    case 2:
                        System.out.println("Qual funcionario deseja demitir?\n\n");
                        for (int i = 0; i < employeeList.size(); i++) {
                            System.out.println("Funcionario #" + (i + 1));
                            employeeList.get(i).showInfo();
                        }

                        employeeList.remove((scan.nextInt() - 1));
                        break;
                
                    case 3:
                    for (int i = 0; i < employeeList.size(); i++) {
                        System.out.println("Funcionario #" + (i + 1));
                        employeeList.get(i).showInfo();
                    }
                        break;
                
                    case 4:
                        System.out.println("Qual funcionario recebera o aumento?");
                        for (int i = 0; i < employeeList.size(); i++) {
                            System.out.println("Funcionario #" + (i + 1));
                            employeeList.get(i).showInfo();
                        }

                        int opt2 = scan.nextInt(); scan.nextLine();
                        employeeList.get(opt2 -1).showInfo();
                        System.out.println("Em quantos porcentos ira aumentar o salario de " +  employeeList.get(opt2 -1).getName());
                        employeeList.get(opt2 - 1).increaseSalary(scan.nextDouble());
                        break;
                    
                    case 5:
                        System.out.println("Encerrando...\nAte a proxima");
                        break;

                    default: System.out.println("Opcao invalida!!!");
                        break;
                }
        } while (opt != 5);

        scan.close();
    }
}
