import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome:");
        String idade = JOptionPane.showInputDialog("Digite sua idade:");

        FileWriter writer = new FileWriter("dados.txt");
        writer.write(nome + "\n" + sobrenome + "\n" + idade);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("dados.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();


        BufferedReader reader2 = new BufferedReader(new FileReader("dados.txt"));
        String line2;
        StringBuilder sb = new StringBuilder();
        while ((line2 = reader2.readLine()) != null) {
            sb.append(line2).append("\n");
        }
        reader2.close();
        JOptionPane.showMessageDialog(null, sb.toString());
    }

}