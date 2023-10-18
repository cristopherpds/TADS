package Exercicio3;

class Corrente extends Conta {
  public Corrente(String nome, int idade, String endereco, double saldo) {
    super(nome, idade, endereco, saldo);
  }

  @Override
  public String tipo() {
    return "Corrente";
  }

  @Override
  public void calcularOperacao() {
    setSaldo(getSaldo() * 0.85);
  }

  private void setSaldo(double d) {
  }
}
