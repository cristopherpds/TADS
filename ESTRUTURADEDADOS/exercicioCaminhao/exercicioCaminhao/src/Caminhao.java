import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Caminhao {
  private final double espacoTotal = 25.0;
  private final ArrayList<Carga> cargas = new ArrayList<>();

  public void adicionarCarga(String nome, String origem, String destinatario, double volume) {
    if (espacoTotal - volume < 0.0001) {
      JOptionPane.showMessageDialog(null, "O caminhão está cheio. Feche a carga.");
      return;
    }

    double espacoSobrando = espacoTotal;
    for (Carga carga : cargas) {
      espacoSobrando -= carga.getVolume();
    }

    if (espacoSobrando - volume < 0.0001) {
      JOptionPane.showMessageDialog(null, "A carga não cabe no caminhão. Feche a carga atual e tente novamente.");
      return;
    }

    cargas.add(new Carga(nome, origem, destinatario, volume));
    JOptionPane.showMessageDialog(null, "Carga " + nome + " adicionada com sucesso.");
  }

  public void fecharCarga() {
    double espacoSobrando = espacoTotal;
    for (Carga carga : cargas) {
      espacoSobrando -= carga.getVolume();
    }

    if (espacoSobrando < 0.0001) {
      JOptionPane.showMessageDialog(null, "Caminhão cheio. Fechando carga.");
    } else {
      JOptionPane.showMessageDialog(null, "Ainda há espaço no caminhão. Espaço sobrando: " + espacoSobrando + "m².");
    }
  }

  public void retirarCarga() {
    if (cargas.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Não há mais cargas no caminhão.");
      return;
    }

    Carga carga = cargas.remove(0);
    JOptionPane.showMessageDialog(null, "Carga retirada: " + carga.getNome() + " de " + carga.getOrigem() + " para "
    + carga.getDestinatario() + " com volume de " + carga.getVolume() + "m².");
  }
}
