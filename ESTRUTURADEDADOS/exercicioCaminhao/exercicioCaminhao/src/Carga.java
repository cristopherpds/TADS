public class Carga {
  private String nome;
  private String origem;
  private String destinatario;
  private double volume;

  public Carga(String nome, String origem, String destinatario, double volume) {
    this.nome = nome;
    this.origem = origem;
    this.destinatario = destinatario;
    this.volume = volume;
  }

  public String getNome() {
    return nome;
  }

  public String getOrigem() {
    return origem;
  }

  public String getDestinatario() {
    return destinatario;
  }

  public double getVolume() {
    return volume;
  }
}
