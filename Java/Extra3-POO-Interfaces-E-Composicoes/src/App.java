import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interfaces.BankSlipPayment;
import Interfaces.CardPayment;
import Interfaces.PaymentMethod;
import Interfaces.PixPayment;
import entities.Client;
import entities.Order;
import entities.OrderProduct;
import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in); //Variaveis e objetos
        List<Product> products = new ArrayList<>();
        List<OrderProduct> orderProductList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        PaymentMethod bankSliPayment = new BankSlipPayment();
        PaymentMethod cardPaymentMethod = new CardPayment();
        PaymentMethod pixPaymentMethod = new PixPayment();

        Product p1 = new Product("Vassora", 26.99);
        products.add(p1);
        Product p2 = new Product("Rodo", 23.99);
        products.add(p2);
        Product p3 = new Product("Pano", 4.99);
        products.add(p3);

        System.out.println("Bem vindo a loja\n"); //Mensagem inicial

        // System.out.println("Digite o nome do Cliente"); //Criação do cliente
        // String name = scan.nextLine();
        // Client client = new Client(name);
        Client client = new Client("Ticole");

        int opt; //Variavel de opções

        //Iniciando o sistema

        do {
            System.out.println("Escolha uma opção\n");
            System.out.println("1- Adicionar um novo produto\n2-Ver produtos\n3-Comprar produtos");
            opt = scan.nextInt(); scan.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String productName = scan.nextLine();

                    System.out.println("Digite o preço do produto:");
                    double productPrice = scan.nextDouble(); scan.nextLine();

                    Product product = new Product(productName, productPrice);
                    products.add(product);

                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                System.out.println();
                for (Product pcdt : products) {
                        System.out.println(pcdt);
                    }
                    break;
                case 3:
                    int confirm;
                    do {

                    System.out.println("Selecione um produto ");
                    System.out.println();
                    for (int i = 0; i < products.size(); i++) {
                        System.out.printf("%d-", i + 1);
                        System.out.println(products.get(i));
                    }
                    System.out.println();
                    System.out.print("Esolha um item: ");
                    int selectedItem = scan.nextInt() - 1; scan.nextLine();

                    System.out.print("Quantos itens deseja comprar: ");
                    int quantity = scan.nextInt(); scan.nextLine();

                    orderProductList.add(new OrderProduct(quantity, products.get(selectedItem)));
                    

                    System.out.println("Deseja comprar mais algum produto? \n\n1-Sim\n2-Não");
                    confirm = scan.nextInt();

                    } while (confirm != 2);
                    orders.add(new Order( (int)(Math.random() *1000), client));
                    for (int i = 0; i < orderProductList.size(); i++) {
                        orders.get(0).addOrderProduct(orderProductList.get(i));
                    }

                   // Colocar um switch para as formas de pagamento 

                System.out.println("Escolha a forma de pagamento:");
                System.out.println("1- Boleto\n2- Cartão\n3- Pix");
                int paymentOption = scan.nextInt(); scan.nextLine();

                switch (paymentOption) {
                    case 1:
                        bankSliPayment.payService(orders.get(0));
                        break;
                    case 2:
                        cardPaymentMethod.payService(orders.get(0));
                        break;
                    case 3:
                        pixPaymentMethod.payService(orders.get(0));
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

                    client.addNewOrder(orders.get(0));

                    

                    orderProductList.clear();
                    orders.clear();

                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 99:
                    break;

                default:
                    break;
            }

        } while(opt != 99);

        scan.close();
    }
}
