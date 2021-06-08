/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Rodrigo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    //procedimento para limpar o terminal/cmd, não funciona na IDE
    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        String nome;
        int opcao;

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite um nome para a conta: ");
        nome = ler.next();

        Cliente c1 = new Cliente(1, nome);
        ContaCorrente cc1 = new ContaCorrente(c1, 321);

        do {
            limparTela();

            System.out.println("\n1 - Depósito\n"
                    + "2 - Saque\n"
                    + "3 - Saldo\n"
                    + "4 - Histórico\n"
                    + "5 - Desativar conta\n"
                    + "6 - Sair\n"
                    + "Digite sua opção: \n");
            opcao = ler.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o valor do depósito: ");
                    cc1.deposito(ler.nextDouble());
                    break;

                case 2:
                    System.out.println("Digite o valor do saque: ");
                    cc1.saque(ler.nextDouble());
                    break;

                case 3:
                    cc1.getSaldo();
                    break;

                case 4:
                    cc1.getHistorico();
                    break;

                case 5:
                    cc1.desativarConta();
                    break;

                case 6:
                    opcao = 0;
                    System.out.println("\nSaindo...\n");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

            System.out.println("\nAperte Enter para continuar...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcao != 0);
    }
}
