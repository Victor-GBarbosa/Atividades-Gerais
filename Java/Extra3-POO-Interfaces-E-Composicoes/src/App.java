import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Bem vindo a loja\n");

        System.out.println("Digite o nome do Cliente");
        String name = scan.nextLine();
        Client client = new Client(name);

        int opt;

        do {
            System.out.println("Escolha uma opção\n");
            System.out.println();
            opt = scan.nextInt(); scan.nextLine();


        } while(opt != 99);

        scan.close();
    }
}
