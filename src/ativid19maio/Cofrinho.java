package ativid19maio;

import java.util.Scanner;

public class Cofrinho {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Olá, sou um Cofrinho Inteligente ===");
        
        System.out.print("Quantas moedas de 0.01? ");
        int qtd_01 = sc.nextInt();

        System.out.print("Quantas moedas de 0.05? ");
        int qtd_05 = sc.nextInt();

        System.out.print("Quantas moedas de 0.10? ");
        int qtd_10 = sc.nextInt();

        System.out.print("Quantas moedas de 0.25? ");
        int qtd_25 = sc.nextInt();

        System.out.print("Quantas moedas de 0.50? ");
        int qtd_50 = sc.nextInt();

        System.out.print("Quantas moedas de 1.00? ");
        int qtd_1 = sc.nextInt();

        // Cálculo do total
        double total = (qtd_01 * 0.01) + (qtd_05 * 0.05) + (qtd_10 * 0.10) +
                       (qtd_25 * 0.25) + (qtd_50 * 0.50) + (qtd_1 * 1.00);

        System.out.printf("\nTotal no cofre: R$ %.2f\n", total);

        double metaSaldo = 100.00;
        if (total >= metaSaldo) {
            System.out.println("Parabéns! Você já atingiu ou ultrapassou os R$ 100,00!");
        } else {
            double faltando = metaSaldo - total;
            System.out.printf("Falta R$ %.2f para atingir R$ 100,00.\n", faltando);

            int semanas = (int) Math.ceil(faltando / total);
            System.out.println("Se você repetir esse mesmo depósito toda semana");
            System.out.println("Você atingirá o Saldo Meta de R$ 100,00 em aproximadamente "
            + semanas + " semanas.");
        }

        sc.close();
    }
}

