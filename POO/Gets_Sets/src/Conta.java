public class Conta {
  private float saldo;

  float getSaldo() {
    return saldo;
  }

  String retirada(float valor) {
    if (this.saldo >= valor) {
      this.saldo = this.saldo - valor;
      return "Retirada realizada com sucesso";
    } else {
      return "Saldo insuficiente para a retirada";
    }
  }

  void deposito(float valor) {
    this.saldo = this.saldo + valor;
  }
}
