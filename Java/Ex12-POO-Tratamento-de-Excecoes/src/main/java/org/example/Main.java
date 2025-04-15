package org.example;

import Exeptions.NotEnoughBalanceExeption;
import Exeptions.OutOfRangeWithdrawExeption;
import entities.BankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira os dados da conta: ");

        System.out.print("Digite o nome: ");
        String name = scan.nextLine();
        System.out.print("Digite o saldo inicial da conta: ");
        double balance = scan.nextDouble();
        System.out.print("Digite o maiximo de saque da conta: ");
        double maxWithdraw = scan.nextDouble();
        double id = Math.round(Math.random() * 10000);
        BankAccount bankAccount = new BankAccount((int)id, name, balance, maxWithdraw);

        System.out.println("id: " + bankAccount.getId() + "\n");

        System.out.println("Quanto deseja sacar?");
        try {
            bankAccount.withdraw(scan.nextDouble());
        } catch (NotEnoughBalanceExeption | OutOfRangeWithdrawExeption erro) {
            System.out.println("Erro ao sacar: " + erro.getMessage());
        } finally {
            System.out.println("Saldo atual " + bankAccount.getBalance());
        }

        System.out.println("Encerrando");





    }
}