import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Quantos produtos deseja adicionar ao estoque?");
        int j = scan.nextInt();
            scan.nextLine();

        Product[] product = new Product[j];
        for (int i = 0; i < product.length; i++) {
            product[i] = new Product("Produto não indentificado", 0.0, 0);
        }

        int opt;

        do {
            System.out.printf("\n\nBem-Vindo ao estoque, o que deseja fazer\n\n1-Adicionar um produto\n2-Remover 1 produto\n3-Sair");
            opt = scan.nextInt();
                scan.nextLine();
                switch (opt) {
                    case 1:
                      for (int i = 0; i < product.length; i++) {
                        if (!product[i].isOccupied()) {
                            product[i].setInfo(); // Parei antes de testar se atribuição dos atributos esta funcionando corretamente
                                                  // Fazer a opção de visualizar os produtos, alterar os preços, e remover os produtos
                        }
                      }  
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4: 
                        break;
                
                    default:
                        break;
                }
        } while (opt != 3);
        


        scan.close();

    }
}
