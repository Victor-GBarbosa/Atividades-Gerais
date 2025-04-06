import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com os dados do Contrato");
        System.out.print("Numero: ");
        int number = scan.nextInt();
        System.out.print("Data: ");
        String dateInput = scan.nextLine();
        LocalDate date = LocalDate.parse(dateInput, fmt);

        System.out.print("Valor do contrato: ");
        Double totalValue = scan.nextDouble();

        System.out.print("Quantidade de parcelas: ");
        int installmentsQuantity = scan.nextInt(); scan.nextLine();

        Contract contract = new Contract(number, date, totalValue, installmentsQuantity);

        scan.close();
    }
}
