package Exercicio2;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    Queue<Pessoa> fila = new LinkedList<>();

    // Criando 5 objetos da classe Civil e adicionando-os na fila
    Civil pessoa1 = new Civil("João", 25, "Rua A, 123", 2000);
    Civil pessoa2 = new Civil("Maria", 30, "Rua B, 456", 2500);
    Civil pessoa3 = new Civil("Pedro", 40, "Rua C, 789", 3000);
    Civil pessoa4 = new Civil("Ana", 35, "Rua D, 1011", 2800);
    Civil pessoa5 = new Civil("Lucas", 28, "Rua E, 1213", 2200);

    fila.add(pessoa1);
    fila.add(pessoa2);
    fila.add(pessoa3);
    fila.add(pessoa4);
    fila.add(pessoa5);

    // Exibindo os dados das pessoas na fila
    StringBuilder dadosFila = new StringBuilder();
    for (Pessoa pessoa : fila) {
      dadosFila.append("Nome: ").append(pessoa.getNome()).append("\n");
      dadosFila.append("Idade: ").append(pessoa.getIdade()).append("\n");
      dadosFila.append("Endereço: ").append(pessoa.getEndereco()).append("\n");
      dadosFila.append("Salário: ").append(pessoa.calcularSalario()).append("\n\n");
    }
    JOptionPane.showMessageDialog(null, dadosFila);

    // Retirando 2 elementos da fila
    fila.remove();
    fila.remove();

    // Exibindo os dados das pessoas na fila novamente
    dadosFila = new StringBuilder();
    for (Pessoa pessoa : fila) {
      dadosFila.append("Nome: ").append(pessoa.getNome()).append("\n");
      dadosFila.append("Idade: ").append(pessoa.getIdade()).append("\n");
      dadosFila.append("Endereço: ").append(pessoa.getEndereco()).append("\n");
      dadosFila.append("Salário: ").append(pessoa.calcularSalario()).append("\n\n");
    }
    JOptionPane.showMessageDialog(null, dadosFila);
  }
}
