package RandomObjects;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    /*
     * O polimorfismo está presente no fato de que as classes Gerente, Programador e
     * Vendedor sao subclasses da classe abstrata Pessoa e implementam o método
     * calcularSalario de forma diferente, permitindo que objetos de diferentes
     * classes sejam armazenados em um ArrayList de Pessoa e que o método
     * calcularSalario seja chamado de forma polimórfica.
     */
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    Random random = new Random();
    int contador = 0;

    for (int i = 0; i < 1000; i++) {
      int tipo = random.nextInt(3);

      String[] nomes = { "João", "Maria", "José", "Ana", "Pedro" };
      int indice = random.nextInt(nomes.length);
      int idade = 20 + random.nextInt(40);
      String endereco = "Endereço " + i;
      double salario = 1000 + random.nextInt(4000);

      switch (tipo) {
        case 0:
          pessoas.add(new Gerente(nomes[indice], idade, endereco, salario));
          break;
        case 1:
          pessoas.add(new Programador(nomes[indice], idade, endereco, salario));
          break;
        case 2:
          pessoas.add(new Vendedor(nomes[indice], idade, endereco, salario));
          break;
      }
      contador++;
    }

    for (int i = 0; i < pessoas.size(); i++) {
      Pessoa pessoa = pessoas.get(i);
      System.out.println("ID: " + (i + 1));
      System.out.println("Nome: " + pessoa.getNome());
      System.out.println("Idade: " + pessoa.getIdade());
      System.out.println("Endereço: " + pessoa.getEndereco());
      System.out.println("Salário normal: " + pessoa.calcularSalario());
      System.out.println("Salário com acréscimo: " + String.format("%.2f", pessoa.calcularSalario()));
      System.out.println();
    }

    System.out.println("Total de dados gerados: " + contador);
  }
}
