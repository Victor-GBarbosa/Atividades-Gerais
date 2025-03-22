import java.util.Scanner;
import entities.Room;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opt = 0;
        int rentHistory = 0;
        Room[] aptos = new Room[10];
        Room[] aptosCopy = new Room[10];
        for (int i = 0; i < aptos.length; i++) {
            aptos[i] = new Room("Não lugado", "Sem contato disponivel", i + 1);
            aptosCopy[i] = new Room("Não lugado", "Sem contato disponivel", i + 1);
        }
        
                do {
            System.out.println("\n\nBem vindo ao pensionato");
            System.out.println();
            System.out.println("O que deseja fazer: \n\n1-Cadastrar um novo\n2-Ver ultimos alugueis\n3-Ver apartamentos disponiveis\n4-Sair");
            opt = scan.nextInt();
            scan.nextLine();
             switch (opt) {
                case 1:
                    System.out.printf("Apartamentos disponiveis:");
                    for (int i = 0; i < aptos.length; i++) {
                        if (aptos[i].isRented()) {
                            continue;
                        } else {
                            System.out.printf(" %d ", i + 1);
                        }
                    }
                    System.out.println("Qual deseja alugar?");
                    int aptToRent = scan.nextInt() - 1; 
                    aptos[aptToRent].rent(rentHistory);
                    rentHistory++;
                    
                    aptos[rentHistory] = aptosCopy[rentHistory];
                    

                    break;
                
                case 2: 
                    

                    for (int i = 0; i < aptos.length; i++) {
                        if (aptos[i].isRented()) {
                        System.out.println("\nRent#" + (aptos[i].getRentHistory() + 1) + "\n");
                        aptosCopy[i].show();
                        }
                    }
                    break;

                case 3: 
                    System.out.printf("Apartamentos disponiveis:");
                    for (int i = 0; i < aptos.length; i++) {
                        if (aptos[i].isRented()) {
                            continue;
                        } else {
                        System.out.printf(" %d ", i + 1);
                        }
                    }
                    break;
                case 4: 
                    break;
                default: System.out.println("Opção invalidada");
                    break;
             }
        } while (opt != 4);

        scan.close();
    }
}


