public class Cachorro {
  private int id;
  private String nome;
  private int idade;
  private String raca;

  public Cachorro(int id, String nome, int idade, String raca) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.raca = raca;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public String getRaca() {
    return raca;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  @Override
  public String toString() {
    return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Raça: " + raca;
  }
}
