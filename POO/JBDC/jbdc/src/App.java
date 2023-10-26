import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        CidadeDAO dao = new CidadeDAO();
        /*
         * for (EstadoCidade cidade : dao.findCidades()) {
         * System.out.println(cidade.getNome());
         * }
         */

        String letra = JOptionPane.showInputDialog("Digite a letra inicial da cidade:");
        boolean found = false;

        for (EstadoCidade cidade : dao.findCidades()) {
            if (cidade.getNome().substring(0, 1).equalsIgnoreCase(letra)) {
                System.out.println(cidade.getNome());
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Nao foi possovel fazar a busqueda " + letra);
        }
    }
}
