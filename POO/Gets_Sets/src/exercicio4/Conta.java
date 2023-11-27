package exercicio4;

public class Conta {
  private float saldo;

  float getSaldo() {
    return saldo;
  }

  boolean retirada(float valor) {
    if (this.saldo >= valor) {
      this.saldo = this.saldo - valor;
      return true;
    } else {
      return false;
    }
  }

  void deposito(float valor) {
    this.saldo = this.saldo + valor;
  }
}
