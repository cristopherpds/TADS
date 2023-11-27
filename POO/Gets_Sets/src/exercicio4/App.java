package exercicio4;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Conta conta = new Conta();

    System.out.print("Digite o saldo a depositar: ");
    float saldoInicial = scanner.nextFloat();
    conta.deposito(saldoInicial);

    System.out.println("Saldo atual: " + conta.getSaldo());

    System.out.print("Digite o valor para retirada: ");
    float valorRetirada = scanner.nextFloat();
    scanner.nextLine();

    boolean retiradaSucesso = conta.retirada(valorRetirada);
    if (retiradaSucesso) {
      System.out.println("Retirada realizada com sucesso");
      System.out.println("Saldo atual: " + conta.getSaldo());
    } else {
      System.out.println("Saldo insuficiente para a retirada");
    }
    scanner.close();
  }
}
