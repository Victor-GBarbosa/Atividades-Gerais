import java.util.Scanner;
import entities.products;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        products a = new products();

        a.getInfo();
        a.show();

        a.addProduct();

        a.show();

        a.subProduct();

        a.show();

        scan.close();
    }
}
