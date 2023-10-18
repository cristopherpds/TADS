package Exercicio3;

class Poupanca extends Conta {
  public Poupanca(String nome, int idade, String endereco, double saldo) {
    super(nome, idade, endereco, saldo);
  }

  @Override
  public String tipo() {
    return "Poupança";
  }
  
  @Override
  public void calcularOperacao() {
    setSaldo(getSaldo() * 1.2);
  }

  private void setSaldo(double d) {
  }
}