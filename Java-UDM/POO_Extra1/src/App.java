import java.util.Scanner;

import entities.Product;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Quantos produtos deseja adicionar ao estoque?");
        int j = scan.nextInt();
            scan.nextLine();
            int count;

        Product[] product = new Product[j];
        for (int i = 0; i < product.length; i++) {
            product[i] = new Product("Produto não indentificado", 0.0, 0);
        }

        int opt;

        do {
            count = 0;
            for (int i = 0; i < product.length; i++) {
                if (!product[i].isOccupied()) {
                    count++;
                }
            }
            System.out.printf("\n\nBem-Vindo ao estoque, o que deseja fazer\n\nEspaços disponiveis: %d\n\n1-Adicionar um produto\n2-Ver produtos cadastrados\n3-Remover produto\n4-Sair\n\n", count);
            opt = scan.nextInt();
                scan.nextLine();
                switch (opt) {
                    case 1:
                        count = 0;
                        for (int i = 0; i < product.length; i++) {
                            if (!product[i].isOccupied()) {
                                count++;
                            }
                        }

                      for (int i = 0; i < product.length; i++) {
                        if (!product[i].isOccupied()) {
                            System.out.printf("Espaços Disponiveis: %d\n\n", count);
                            product[i].setInfo();
                            break;      
                        }                       
                      }  
                        break;
                    case 2:
                      for (int i = 0; i < product.length; i++) {
                        if (product[i].isOccupied()) {
                            product[i].getProduct();
                        }
                      }
                        break;
                    case 3:
                        int tempCounter = 1;
                        System.out.println("Qual produto deseja remover?");
                        for (int i = 0; i < product.length; i++) {
                            if (product[i].isOccupied()) {
                                System.out.printf("\n#Produto %d\n", tempCounter);
                                product[i].getProduct();
                            }
                      }
                        break;
                    case 4: 
                        break;
                
                    default:
                        break;
                }
        } while (opt != 4);
        


        scan.close();

    }
}
