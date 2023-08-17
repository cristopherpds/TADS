public class ContaBancaria {
  private String titular;
  private int numeroConta;
  private double saldo;
  private boolean contaAtiva;

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public boolean isContaAtiva() {
    return contaAtiva;
  }

  public void setContaAtiva(boolean contaAtiva) {
    this.contaAtiva = contaAtiva;
  }


    public void depositar(double valor) {
        if (contaAtiva && valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Não foi possível realizar o depósito. Conta bloqueada");
        }
    }

    public void sacar(double valor) {
        if (contaAtiva && valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Não foi possível realizar o saque. Conta bloqueada");
        }
    }

    public void mostrarSaldo() {
        System.out.println( titular +" Tem o saldo atual de: " + saldo);
    }

  @Override
  public String toString() {
    return "ContaBancaria [titular=" + titular + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", contaAtiva="
        + contaAtiva + "]";
  }
}
