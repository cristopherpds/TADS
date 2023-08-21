public class Pessoa {
  private String nome;
  private int idade;
  private float quantVida;
  private float habilidadeParaAtirar;
  private float habilidadeParaTransacao;

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

  public float getHabilidadeParaAtirar() {
    return habilidadeParaAtirar;
  }

  public void setHabilidadeParaAtirar(float habilidadeParaAtirar) {
    this.habilidadeParaAtirar = habilidadeParaAtirar;
  }

  public float getHabilidadeParaTransacao() {
    return habilidadeParaTransacao;
  }

  public void setHabilidadeParaTransacao(float habilidadeParaTransacao) {
    this.habilidadeParaTransacao = habilidadeParaTransacao;
  }

  public void jogarBolaComCachorro(Cachorro cachorro) {
    System.out.println("Você jogou a bola para o cachorro!");
    float habilidade = this.getHabilidadeParaAtirar();
    float distancia = (float) (Math.random() * habilidade);
    float tempo = distancia / habilidade;
    System.out.println("O cachorro correu " + distancia + " metros para pegar a bola em " + tempo + " segundos.");
    cachorro.pegarBola();
  }

  public void realizarTransacao(ContaBancaria contaBancaria, float valor) {
    System.out.println("Você realizou uma transação bancária!");
    float habilidade = this.getHabilidadeParaTransacao();
    float chanceDeErro = (habilidade - contaBancaria.getSeguranca()) / habilidade;
    if (Math.random() > chanceDeErro) {
      contaBancaria.depositar(valor);
      System.out.println("Transação realizada com sucesso!");
    } else {
      System.out.println("A transação falhou devido a problemas de segurança.");
    }
  }
    
  @Override
  public String toString() {
    return "Pessoa [nome=" + nome + ", idade=" + idade + ", quantVida=" + quantVida + ", habilidadeParaAtirar="
        + habilidadeParaAtirar + ", habilidadeParaTransacao=" + habilidadeParaTransacao + "]";
  }

}
