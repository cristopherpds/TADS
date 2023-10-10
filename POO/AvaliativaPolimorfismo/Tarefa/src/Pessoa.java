public class Pessoa {
  private String nome;
  private int idade;
  private String endereco;

  public Pessoa(String nome, int idade, String endereco) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "Pessoa [nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + ", salarioAcresimo=" + calcularSalario() + "]";
  }

  public double calcularSalario() {
    return 0;
  }

}
