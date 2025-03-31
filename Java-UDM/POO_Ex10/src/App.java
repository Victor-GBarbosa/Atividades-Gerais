import entities.ImportedProduct;
import entities.Product;
import entities.UsedProdect;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        List<Product> lista = new ArrayList<>();
        lista.add(new Product("Tablet", 399.99));
        lista.add(new UsedProdect("Relogio", 99.99, "19/07/2015"));
        lista.add(new ImportedProduct("Wooting 60he", 1299.99, 95));

     int mainOpt;
         do {
            System.out.println("\n\nBem vindo a Matue imports");
            System.out.println("\n1-Adicionar um produto\n2-Remover Produto\n3-Ver lista de produtors\n4-Sair");
            System.err.print("\nEscolha uma opção: ");
            mainOpt = scan.nextInt(); scan.nextLine();

            switch (mainOpt) {
                case 1:
                    System.out.println("Qual seria o nome do produto?");
                    String name = scan.nextLine();
                    System.out.println("Qual sera o preço do produto?");
                    double price = scan.nextDouble(); scan.nextLine();
                    System.out.println("Escolha o tipo do produto\n\n1-Comum\n2-Importado\n3-Usado");
                    boolean validOpt;
                    do {
                    int productType = scan.nextInt(); scan.nextLine();
                    switch (productType) {
                        case 1:
                            lista.add(new Product(name, price));
                            validOpt = true;
                            break;
                        case 2:
                            
                            System.out.println("Qual é a taxa alfandegaria do produto?");
                            double customsFee = scan.nextDouble(); scan.nextLine();
                            lista.add(new ImportedProduct(name, price, customsFee));
                            validOpt = true;
                            break;
                        case 3:
                        System.out.println("Qual é a data de fabricação do produto?");
                            String manufectureDate = scan.nextLine();
                            lista.add(new UsedProdect(name, price, manufectureDate));
                            validOpt = true;
                            break;
                        default:
                            System.out.println("Tipo de produto inválido. Tente novamente.");
                            validOpt = false;
                            break;
                    } 
                    } while (!validOpt);
                    break;
                case 2:
                    System.out.println("Função não implementada.");
                    break;
                case 3:
                    System.out.println("Lista de produtos:");
                    // Código para exibir a lista de produtos
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println();
                        lista.get(i).getInfo();
                        
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
         } while (mainOpt != 4);

         scan.close();
    } 
    }

