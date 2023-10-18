package Exercicio2;

class Programador extends Pessoa {
  private double salario;

  public Programador(String nome, int idade, String endereco, double salario) {
    super(nome, idade, endereco);
    this.salario = salario;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  @Override
  public double calcularSalario() {
    return salario * 1.1;
  }

  @Override
  public String toString() {
    return "Programador";
  }
}