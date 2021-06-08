/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class ContaCorrente {

    private Cliente cliente;
    private int numeroConta;
    private double saldo;
    private List<String> historico = new ArrayList<>();
    private String status;

    public ContaCorrente(Cliente cliente, int numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.status = "Ativo";
        this.historico.add("- Conta " + this.numeroConta + "(Cliente: " + this.cliente.getNome() + ") criada");
    }

    public void deposito(double valor) {
        if (this.status.equals("Ativo")) {
            this.saldo += valor;

            System.out.println("\nDeposito de R$" + valor + " realizado com sucesso!");
            this.historico.add("- Deposito de R$" + valor);
        } else {
            System.out.println("Conta foi desativada!");
        }
    }

    public void saque(double valor) {

        if (this.status.equals("Ativo")) {
            if ((valor + (valor * 0.0033)) < this.saldo) {
                this.saldo -= (valor + (valor * 0.0033));
                System.out.println("\nSaque de R$" + valor + " realizado com sucesso!\nA taxa foi de R$" + valor * 0.0033);
                this.historico.add("- Saque de R$" + valor + ". A taxa foi de R$" + valor * 0.0033);
            } else if (this.saldo == 0) {
                System.out.println("A conta não possui saldo!");
            } else {
                System.out.println("\nImpossível realizar saque! Valor de saque, incluindo \ntaxas (R$" + valor + " + R$" + (valor * 0.0033)
                        + ") é maior que o saldo da conta (" + this.saldo + ")");
            }
        } else {
            System.out.println("Conta foi desativada!");
        }
    }

    public void getSaldo() {
        System.out.println("\nO saldo atual da conta " + this.numeroConta + " é de R$" + this.saldo);
    }

    public void getHistorico() {

        System.out.println("\n[Histórico da conta " + this.numeroConta + "]");
        System.out.println("\nCliente: " + this.cliente.getNome() + ". Id: " + this.cliente.getId() + "\nStatus: " + this.status);

        for (String lista : this.historico) {
            System.out.println(lista);
        }
    }

    public void desativarConta() {

        if (this.status.equals("Ativo")) {
            this.status = "Inativo";

            if (this.saldo > 0) {
                System.out.println("\nSaque final de R$" + (this.saldo - this.saldo * 0.0033) + " realizado");
                this.historico.add("- Saque de R$" + (this.saldo - this.saldo * 0.0033) + ". A taxa foi de R$" + this.saldo * 0.0033);
                this.saldo = 0;
            }
            System.out.println("Conta " + this.numeroConta + "(Cliente: " + this.cliente.getNome() + ") inativada com sucesso!");
            this.historico.add("- Conta " + this.numeroConta + "(Cliente: " + this.cliente.getNome() + ") inativada");
        } else {
            System.out.println("A conta já está desativada!");
        }
    }
}
