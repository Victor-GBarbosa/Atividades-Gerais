import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao Sistema de Pedidos!");
        System.out.println("\n1-Fazer pedido\n2-Consultar pedidos\n3-Adicionar um item\n4-remover um item\n5-Sair");
        int n = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Escolha uma opção: ");
        n = scan.nextInt();

        switch (n) {
            case 1:
            
            break;
            case 2:
            
            break;
            case 3:
            
            break;
            case 4:
            
            break;
            case 5:
            
            break;
            default:
            System.out.println("Opção inválida!");
            break;
        }

        scan.close();

    }
}
