import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bebida {
    public static void main(String[] args) throws IOException {
        ArrayList<String> listaBebida = new ArrayList<>();

        while (true) {
            String nome = JOptionPane.showInputDialog("Digite o nome da bebida ou 'sair' para terminar:");
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            String custo = JOptionPane.showInputDialog("Digite o custo da bebida:");
            String descricao = JOptionPane.showInputDialog("Digite a descrição da bebida:");
            String estoque = JOptionPane.showInputDialog("Digite a quantidade em estoque da bebida:");

            String bebida = nome + ";" + custo + ";" + descricao + ";" + estoque;
            listaBebida.add(bebida);
        }

        FileWriter writer = new FileWriter("bebidas.txt");
        for (String bebida : listaBebida) {
            writer.write(bebida + "\n");
        }
        writer.close();
    }
}