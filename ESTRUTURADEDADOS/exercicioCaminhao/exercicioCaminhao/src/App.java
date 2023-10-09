import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Caminhao caminhao = new Caminhao();
        
        /* caminhao.adicionarCarga("Carga 1", "São Paulo", "Rio de Janeiro", 10.0);
        caminhao.adicionarCarga("Carga 2", "Belo Horizonte", "Brasília", 15.0);
        caminhao.adicionarCarga("Carga 3", "Curitiba", "Porto Alegre", 5.0);
        caminhao.fecharCarga();
        caminhao.retirarCarga();
        caminhao.retirarCarga();
        caminhao.retirarCarga();
        caminhao.retirarCarga(); */
        while (true) {
            String[] opcoes = { "Adicionar Carga", "Mostrar Espaço Restante", "Retirar Carga Mais Próxima", "Sair" };
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Caminhão Transportadora",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    String nome = JOptionPane.showInputDialog("Nome da carga:");
                    String origem = JOptionPane.showInputDialog("Origem da carga:");
                    String destinatario = JOptionPane.showInputDialog("Destinatário da carga:");
                    double volume = Double.parseDouble(JOptionPane.showInputDialog("Volume da carga (em m²):"));
                    caminhao.adicionarCarga(nome, origem, destinatario, volume);
                    break;
                case 1:
                    caminhao.fecharCarga();
                    break;
                case 2:
                    caminhao.retirarCarga();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
