package Exercicio3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    /* 
     * O polimorfismo nesse contexto esta presente na criação do ArrayList de Conta, que pode armazenar objetos das classes Poupanca e Corrente, que são subclasses de Conta. Isso permite que o loop que itera sobre as contas possa chamar os métodos "tipo()"" e "calcularOperacao()"" de forma polimórfica, ou seja, sem saber exatamente qual é o tipo de cada objeto.
     */
    String[] nomes = { "João", "Maria", "José", "Ana", "Pedro" };

    ArrayList<Conta> contas = new ArrayList<>();

    Random random = new Random();
    int contador = 0;

    for (int i = 0; i < 1000; i++) {
      int tipo = random.nextInt(2);
      int indice = random.nextInt(nomes.length);
      int idade = 20 + random.nextInt(40);
      String endereco = "Endereço " + i;
      double saldo = 1000 + random.nextInt(4000);

      switch (tipo) {
        case 0:
          contas.add(new Poupanca(nomes[indice], idade, endereco, saldo));
          break;
        case 1:
          contas.add(new Corrente(nomes[indice], idade, endereco, saldo));
          break;
      }

      contador++;
    }

    for (int i = 0; i < contas.size(); i++) {
      Conta conta = contas.get(i);
      System.out.println("ID: " + (i + 1));
      System.out.println("Tipo de conta: " + conta.tipo());
      System.out.println("Nome: " + conta.getNome());
      System.out.println("Idade: " + conta.getIdade());
      System.out.println("Endereço: " + conta.getEndereco());
      System.out.println("Saldo: " + conta.getSaldo());
      conta.calcularOperacao();
      System.out.println("Saldo após operação: " + conta.getSaldo());
      System.out.println();
    }

    System.out.println("Total de dados gerados: " + contador);
  }
}
