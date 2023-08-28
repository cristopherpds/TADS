import java.util.ArrayList;

class Pessoa {
  private String nome;
  private int idade;

  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }
}

public class Programa3 {
  public static void main(String[] args) {
    ArrayList<Pessoa> pessoas = new ArrayList<>();


    pessoas.add(new Pessoa("Cristopher", 25));
    pessoas.add(new Pessoa("Pedro", 30));
    pessoas.add(new Pessoa("Carol", 28));

    System.out.println("Pessoas no ArrayList:");
    for (int i = 0; i < pessoas.size(); i++) {
      Pessoa pessoa = pessoas.get(i);
      System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
    }
  }
}
