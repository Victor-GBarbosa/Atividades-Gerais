package entities;

import java.util.Scanner;

public class products {
    public String name;
    public double price;
    public int quantity;
    public double worth;

    Scanner scan = new Scanner(System.in);

     

public double mworth() {
    return this.worth = price * (double) quantity;
}

public void show() {
    System.out.printf("Produto \n\nNome: %s\nPreço: %.2f\nQuantidade (em estoque): %d\n\nValor total do estoque: %.2f\n\n", this.name, this.price, this.quantity, this.mworth());
}

public void getInfo() {
    System.out.printf("Digite o nome do produto\n");
        this.name = scan.nextLine();
        System.out.printf("Digite o valor do produto\n");
        this.price = scan.nextDouble();
        System.out.printf("Digite a quantidade do produto (em estoque)\n");
        this.quantity = scan.nextInt();
}

public void addProduct() { 
    System.out.printf("\nQuantos produtos deseja adicionar?: ");
    this.quantity = this.quantity + scan.nextInt();
}

public void subProduct() {
    System.out.printf("\nQuantos produtos deseja retirar?: ");
    this.quantity = this.quantity - scan.nextInt();
}


}

