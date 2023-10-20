package Exercicio3;

class Civil extends Pessoa {
  private double salario;

  public Civil(String nome, int idade, String endereco, double salario) {
    super(nome, idade, endereco);
    this.salario = salario;
  }

  public double calcularSalario() {
    return salario - (salario * 0.1);
  }
}