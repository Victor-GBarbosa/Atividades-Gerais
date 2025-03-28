import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.println("Insira as informações do cliente");
        System.out.print("Nome: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Data de nascimento: ");
        String bd = scan.nextLine();

        Client client = new Client(name, email, bd);

        System.out.println("Insira as informações do pedido:");
		System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.next());
        System.out.println(status);

        System.out.print("Quantos produtos serão comprados: ");

        scan.close();

        int n = scan.nextInt();

        for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			scan.nextLine();
			String productName = scan.nextLine();
			System.out.print("Product price: ");
			double productPrice = scan.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int quantity = scan.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product); 

			order.addItem(orderItem);
		}


    }
}
