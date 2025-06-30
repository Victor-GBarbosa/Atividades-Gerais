package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashSet<String> emails = new HashSet<String>();
        HashSet<String> emailsDup = new HashSet<String>();
        int opt = 0;
        Scanner scan  = new Scanner(System.in);
        do {
            System.out.println("=======SISTEMA DE EMAILS=======\n");
            System.out.println("1- Inserir novo email ");
            System.out.println("2- Listar emails ");
            System.out.printf("\nEscolha uma opção: ");
            opt = scan.nextInt(); scan.nextLine();

            switch (opt) {

                case 1:
                    System.out.print("Digite o nome do email: ");
                    String email = scan.nextLine();
                    if (!(email.contains("@") && email.contains("."))) {
                        System.out.println("Email invalido");
                        break;
                    }
                    if(!emails.add(email)) {
                        emailsDup.add(email);
                    }
                    break;
                case 2:
                    for (String emailItem : emails ) {
                        System.out.println(emailItem);
                    }
                    System.out.println("\nEmais duplicados: " + emailsDup.size());
                    break;
            }
        } while (opt != 0);

    }
}
