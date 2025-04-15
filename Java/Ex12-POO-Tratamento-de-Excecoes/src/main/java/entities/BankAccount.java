package entities;

import Exeptions.NotEnoughBalanceExeption;
import Exeptions.OutOfRangeWithdrawExeption;

public class BankAccount {
    private int id;
    private String nome;
    private double balance;
    private double maxWithdraw;
    public BankAccount() {}


    public BankAccount(int id, String nome, double balance, double maxWithdraw) {
        this.id = id;
        this.nome = nome;
        this.balance = balance;
        this.maxWithdraw = maxWithdraw;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBalance() {
        return balance;
    }


    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(double maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    public void withdraw(double qunatity) throws OutOfRangeWithdrawExeption, NotEnoughBalanceExeption {
        if (qunatity > balance) {
            throw new NotEnoughBalanceExeption("Dinheiro insuficiente na conta");
        } else if (qunatity > maxWithdraw) {
            throw new OutOfRangeWithdrawExeption("Quantidade do saque não pode ser maior que a quantidade maxima de saque");
        } else {
            balance -= qunatity;
        }

    }
}
