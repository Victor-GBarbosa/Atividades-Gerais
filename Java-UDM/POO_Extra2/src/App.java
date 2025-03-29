import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import entities.Item;
import entities.Order;
import entities.OrderItem;

public class App {
    public static void main(String[] args) throws Exception {
       
        int n = 0;
        Scanner scan = new Scanner(System.in);

        List<Item> items = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        do {
            System.out.println("Bem vindo ao Sistema de Pedidos!");
            System.out.println("\n1-Fazer pedido\n2-Consultar pedidos\n3-Adicionar um item\n4-Ver itens\n5-Remover item\n6-Sair");
            System.out.print("\nEscolha uma opção: ");
            n = scan.nextInt();
            scan.nextLine(); 
            switch (n) {
                case 1:
                int buyMore;
                OrderItem newOrderItem = new OrderItem();
                Order newOrder = new Order();
                    do {
                    //Exibir os produtos              
                    System.out.println("Escolha um item: \n");
                        if (items.isEmpty()) {
                            System.out.println("Ainda não há itens disponiveis");
                        } else {
                        System.out.println("Itens disponíveis:");
                            for (int i = 0; i < items.size(); i++) {
                                System.out.println((i + 1) + " - " + items.get(i).getName() + " (R$ " + items.get(i).getPrice() + ")");
                            }
                        }
                        
                    //Escolhe o produto
                    int opt1 = scan.nextInt() - 1; scan.nextLine();
                    System.out.println("\nQuantos \"" + items.get(opt1).getName() + "\" Voce deseja comprar");
                    int quantity = scan.nextInt();

                    //Criando o pedido do produto
                    newOrderItem.setItem(items.get(opt1));
                    newOrderItem.setQuantity(quantity);
                    newOrder.addOrderItem(newOrderItem);
                    
                    System.out.println("Voce deseja comprar mais alguma coisa?\n1-sim\n2-não");
                    buyMore = scan.nextInt();
                    if (buyMore != 1) {
                        orders.add(newOrder);
                    }
                } while (buyMore == 1);
                    buyMore = 0;
        
                    break;
                case 2:
                    // ...existing code...
                    break;
                case 3:
                    System.out.println("\nDigite o nome do item: ");
                    String name = scan.nextLine();
                    System.out.println("\nDigite o preço do item: ");
                    double price = scan.nextDouble();
                    scan.nextLine(); 
                    Item item = new Item(name, price);
                    items.add(item);
                    break;
                case 4:
                    if (items.isEmpty()) {
                        System.out.println("A lista de itens está vazia.");
                    } else {
                        System.out.println("Itens disponíveis:");
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + " - " + items.get(i).getName() + " (R$ " + items.get(i).getPrice() + ")");
                        }
                    }
                    break; 
                case 5:
                    if (items.isEmpty()) {
                        System.out.println("A lista de itens está vazia.");
                    } else {
                        System.out.println("Itens disponíveis:");
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + " - " + items.get(i).getName() + " (R$ " + items.get(i).getPrice() + ")");
                        }
                        System.out.print("Digite o número do item que deseja remover: ");
                        int pos = scan.nextInt();
                        scan.nextLine(); 
                        if (pos > 0 && pos <= items.size()) {
                            items.remove(pos - 1);
                            System.out.println("Item removido com sucesso!");
                        } else {
                            System.out.println("Número inválido!");
                        }
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (n != 6);
        scan.close();
    }
}
