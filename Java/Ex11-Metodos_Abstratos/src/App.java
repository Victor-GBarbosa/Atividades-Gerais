import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        int mainOpt; 
        do {
            System.out.println("-----Receita Federal-----\n");
            System.out.println("1-Ver impostos cobrados\n2-Adicionar contribuinte");
            mainOpt = scan.nextInt(); scan.nextLine();

            switch (mainOpt) {
                case 1:
                    for (TaxPayer taxPayer : taxPayers) {
                        System.out.println(taxPayer.toString());
                    }
                    break;

                case 2:
                    System.out.println("\n1-Empresarial\n2-Individual");
                    int opt = scan.nextInt(); scan.nextLine();
                    switch (opt) {
                        case 1:
                            
                            System.out.println("Digite o nome da empresa:");
                            String name = scan.nextLine();

                            System.out.println("Digite a renda anual da empresa:");
                            double annualIncome = scan.nextDouble(); scan.nextLine();

                            System.out.println("Digite o número de funcionários:");
                            int numberOfEmployees = scan.nextInt(); scan.nextLine();

                            TaxPayer company = new Company(name, annualIncome, numberOfEmployees);
                            taxPayers.add(company);

                            System.out.println("Empresa adicionada com sucesso!");
                            break;
                        
                        case 2:
                            System.out.println("Digite o nome do indivíduo:");
                            name = scan.nextLine();

                            System.out.println("Digite a renda anual do indivíduo:");
                            annualIncome = scan.nextDouble(); scan.nextLine();
                            // if (){
                            System.out.println("Digite os gastos com saúde:");
                            double healthExpenditures = scan.nextDouble(); scan.nextLine();
                            // }
                            TaxPayer individual = new Individual(name, annualIncome, healthExpenditures);
                            taxPayers.add(individual);

                            System.out.println("Indivíduo adicionado com sucesso!");
                            break;
                        
                        default: System.out.println("Opção invalida");
                            break;
                    }
                
                case 3:
                    
                    break;
            
                default: System.out.println("Opção invalida");
                    break;
            }
        } while (mainOpt != 3);


        scan.close();
    }
}
