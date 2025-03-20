import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Quantas pessoas deseja inserir na lista?");
        int i = scan.nextInt(); 
        scan.nextLine();
        double averageHeight = 0;
    
        String[] name = new String[i];
        int[] age = new int[i];
        double[] height = new double[i];

        for (int j = 0; j < age.length; j++) {
            System.err.println("\nQual o nome da " + (j + 1) + "a pessoal?");
            name[j] = scan.nextLine();
            System.err.println("\nQual a idade da " + (j + 1) + "a pessoal?");
            age[j] = scan.nextInt();
            scan.nextLine();
            System.err.println("\nQual a altra da " + (j + 1) + "a pessoal?");
            height[j] = scan.nextDouble();
            scan.nextLine();
        }

        for (int j = 0; j < height.length; j++) {
            averageHeight += height[j];
        }

        averageHeight = averageHeight / i;


        int a = 0; 
        for (int j = 0; j < age.length; j++) {
            if (age[j] < 16) {
                a++;
            }
        } String[] under16 = new String[a]; a = 0;

        for (int j = 0; j < age.length; j++) {
            if (age[j] < 16) { 
                under16[a] = name[j];
                a++;
            }
        }

        for (int j = 0; j < name.length; j++) {
            System.out.println("\n\nPessoa n" + j + "\n"); 
            System.out.println("Nome: " + name[j]); 
            System.out.println("Idade: " + age[j]);
            System.out.println("Altura: " + height[j]);
        }

        System.out.println("\n\n-----------------------------\n\nMenores de 16 (" + under16.length + ")\n\n");
        for (int j = 0; j < under16.length; j++) {
            System.out.println(under16[j]);
        }

        System.out.println("\n\nMedia de altura: " + averageHeight);

        scan.close();

    }
}
