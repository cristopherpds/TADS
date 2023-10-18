package Exercicio3;

abstract class Conta {
  private String nome;
  private int idade;
  private String endereco;
  private double saldo;

  public Conta(String nome, int idade, String endereco, double saldo) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
    this.saldo = saldo;
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

  public double getSaldo() {
    return saldo;
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

  public void deposita(double valor) {
    saldo += valor;
  }

  public void retira(double valor) {
    saldo -= valor;
  }

  public abstract String tipo();

  public abstract void calcularOperacao();
}
