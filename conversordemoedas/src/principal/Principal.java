package principal;

import calculos.ConversorMoedas;

import java.util.Scanner;

import static calculos.ConversorMoedas.*;


public class Principal {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("=== Conversor de Moedas ===");
            System.out.println("1) USD → BRL");
            System.out.println("2) BRL → USD");
            System.out.println("3) USD → EUR");
            System.out.println("4) EUR → USD");
            System.out.println("5) BRL → EUR");
            System.out.println("6) EUR → BRL");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            if (opcao == 0) {;
                listarCotacoesUsadas();
                gerarArquivoCotacoesUsadas();
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = sc.nextDouble();

            switch (opcao) {
                case 1 -> converter("USD", "BRL", valor);
                case 2 -> converter("BRL", "USD", valor);
                case 3 -> converter("USD", "EUR", valor);
                case 4 -> converter("EUR", "USD", valor);
                case 5 -> converter("BRL", "EUR", valor);
                case 6 -> converter("EUR", "BRL", valor);
                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
