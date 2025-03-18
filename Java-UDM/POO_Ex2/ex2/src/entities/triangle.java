package entities;

import java.util.Scanner;

public class triangle {
    public double width;
    public double height;

    Scanner scan = new Scanner(System.in);

   public void getInfo() {
    System.out.printf("Qual a altura do retangulo? ");
    this.height = scan.nextDouble();
    System.out.printf("Qual a largura do retangulo? ");
    this.width = scan.nextDouble();
   }
   
    public double getArea() {
    return this.width * this.height;
   } 
   
   public double getPerimeter() {
    return (this.width + this.height) * 2;
   }

   public double getDiagonal() {
    return Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
   }

   public void showInfo() {
    System.out.printf("\nArea = %.2f\nPerimetro: %.2f\nDiagonal: %.2f\n\n", this.getArea(), this.getPerimeter(), this.getDiagonal());
   }


}                     
