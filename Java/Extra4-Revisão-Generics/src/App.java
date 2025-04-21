import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        GenericClass<Integer> IntegerClass = new GenericClass<>();
        GenericClass<Double> DoubleClass = new GenericClass<>();

        System.out.println("Tipo inteiro\n");

         System.out.print("\nDigite o valor de x: ");
         IntegerClass.x = scan.nextInt();


         System.out.print("\nDigite o valor de y: ");
         IntegerClass.y = scan.nextInt();



         System.out.println("\nTipo Double");

         System.out.print("\nDigite o valor de x: ");
         DoubleClass.x = scan.nextDouble();


         System.out.print("\nDigite o valor de y: ");
         DoubleClass.y = scan.nextDouble();

         System.out.printf("Valores inteiros x =%d y=%d\n", IntegerClass.x, IntegerClass.y);
         System.out.printf("Valores Double x =%.2f y=%.2f", DoubleClass.x, DoubleClass.y);

        scan.close();
    }
}
