import java.util.Scanner;

import entities.User;

public class App {
    public static void main(String[] args) throws Exception {
        int popt;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do cliente");
        String name = scan.nextLine();

        System.out.println("Digite o id da conta");
        int id = scan.nextInt();

        User user = new User(name, id);

        System.out.println("Voce deseja adicionar um valor inicial a conta?\n\n1-Sim\n2-Nao");
        int opt = scan.nextInt();

        if (opt == 1) {
            user.doposit();
        }

        do {
            System.out.printf("\n\nO que deseja fazer? \n\n1-Depositar\n2-Sacar\n3-Ver saldo\n4-Sair\n\nOpcao: ");
            popt = scan.nextInt();

            switch (popt) {
                case 1:
                    user.doposit();
                    break;
                case 2:
                    user.withdraw();
                    break;
                case 3:
                    System.out.printf("\n\nNome: %s\nID da conta: %d \n\nSaldo: %.2f", user.getName(), user.getAccontId(), user.getBalance());
                    break;
                case 4:
                
                    break;
                default: System.out.println("Opcao invalida");
                    break;
            }

        } while (popt != 4);

        scan.close();
    }
}
