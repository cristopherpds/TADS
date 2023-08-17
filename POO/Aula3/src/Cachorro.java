public class Cachorro {
  private String nome;
  private int idade;
  private float quantVida;
  private String corDoPelo;
  private float forcaDaMordida;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public float getQuantVida() {
    return quantVida;
  }

  public void setQuantVida(float quantVida) {
    this.quantVida = quantVida;
  }

  public String getCorDoPelo() {
    return corDoPelo;
  }

  public void setCorDoPelo(String corDoPelo) {
    this.corDoPelo = corDoPelo;
  }

  public float getForcaDaMordida() {
    return forcaDaMordida;
  }

  public void setForcaDaMordida(float forcaDaMordida) {
    this.forcaDaMordida = forcaDaMordida;
  }

  public void latir() {
        System.out.println(nome + " está latindo! Ahu ahu auh");
    }

  @Override
  public String toString() {
    return "Cachorro [nome=" + nome + ", idade=" + idade + ", quantVida=" + quantVida + ", corDoPelo=" + corDoPelo
        + ", forcaDaMordida=" + forcaDaMordida + "]";
  }

}
