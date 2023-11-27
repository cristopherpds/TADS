public class Pessoa {
  private String nome;
  private int idade;

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  /*
   * public void setNome(String nome) {
   * this.nome = nome;
   * }
   */
  public boolean setNome(String nome) {
    if (!nome.isEmpty()) {
      this.nome = nome;
      return true;
    } else {
      return false;
    }
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String verificarIdade() {
    if (idade >= 0 && idade <= 3) {
      return "Bebê";
    } else if (idade >= 4 && idade <= 12) {
      return "Criança";
    } else if (idade >= 13 && idade <= 17) {
      return "Adolescente";
    } else if (idade >= 18 && idade <= 59) {
      return "Adulto";
    } else {
      return "Idoso";
    }
  }
}
