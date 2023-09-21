package Mamiferos;

public abstract class Mamiferos {
  private String vocalizacao;
  private String nomeEspecie;

  public Mamiferos(String vocalizacao, String nomeEspecie) {
    this.vocalizacao = vocalizacao;
    this.nomeEspecie = nomeEspecie;
  }

  public String som() {
    return vocalizacao;
  }

  public String nome() {
    return nomeEspecie;
  }

  public void setNome(String nomeEspecie) {
    this.nomeEspecie = nomeEspecie;
  }
}
