public class PessoaProgamador extends Pessoa{

  private double salario;

  public PessoaProgamador(String nome, int idade, String endereco, double salario) {
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
  public String toString() {
    return "PessoaProgamador [salario=" + salario + ", nome=" + getNome() + ", idade=" + getIdade()
        + ", endereco=" + getEndereco() + "]";
  }

  @Override
  public double calcularSalario() {
    return this.salario * 1.1;
  }
}
