import java.util.ArrayList;
import java.util.Scanner;

public class Programa5 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    int idade;
    do {
      System.out.print("Digite o nome da pessoa: ");
      String nome = scanner.nextLine();

      System.out.print("Digite a idade da pessoa: ");
      idade = scanner.nextInt();
      scanner.nextLine(); 

      pessoas.add(new Pessoa(nome, idade));
    } while (idade != 3);

    /* O loop a seguir usa um loop for tradicional para iterar sobre o ArrayList
    e recuperar cada objeto Pessoa. Em seguida, imprime o nome e a idade de cada um
    usando os métodos getter. */
    System.out.println("Registros no ArrayList (for normal):");
    for (int i = 0; i < pessoas.size(); i++) {
      Pessoa pessoa = pessoas.get(i);
      System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
    }

    /* Iteração usando for-each (loop de aprimoramento) para acessar cada objeto Pessoa.
    Imprime nome e idade usando métodos getter de cada objeto.
    A principal diferença é que não há necessidade de acessar o índice ou usar o método
    get() para obter cada objeto da lista. O loop é mais conciso e intuitivo.*/
    System.out.println("\nRegistros no ArrayList (for comprimido):");
    for (Pessoa pessoa : pessoas) {
      System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
    }
    
    scanner.close();
  }
}
