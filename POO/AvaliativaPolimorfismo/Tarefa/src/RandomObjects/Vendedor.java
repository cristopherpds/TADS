package RandomObjects;

class Vendedor extends Pessoa {
  private double salario;

  public Vendedor(String nome, int idade, String endereco, double salario) {
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
    return salario * 1.3;
  }

  @Override
    public String toString() {
        return "Vendedor";
    }
}
