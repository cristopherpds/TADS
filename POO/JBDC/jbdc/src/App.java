import java.util.List;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {

        CidadeDAO cidadeDAO = new CidadeDAO();
        List<EstadoCidade> cidades = cidadeDAO.findCidades();
        StringBuilder sbEstadoCidade = new StringBuilder();

        for (EstadoCidade c : cidades) {
            sbEstadoCidade.append("ID: ").append(c.getId()).append("\n");
            sbEstadoCidade.append("Nome: ").append(c.getNome()).append("\n");
        }
        System.out.println(sbEstadoCidade.toString());

        /* String letra = JOptionPane.showInputDialog("Digite a letra inicial da cidade:");
        boolean found = false;

        for (EstadoCidade cidade : cidadeDAO.findCidades()) {
            if (cidade.getNome().substring(0, 1).equalsIgnoreCase(letra)) {
                System.out.println(cidade.getNome());
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Nao foi possovel fazar a busqueda " +
                    letra);
        } */

    }
}
