package Exercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
  private static Queue<Pessoa> fila = new LinkedList<>();
  private static ArrayList<Pessoa> atendidos = new ArrayList<>();

  public static void main(String[] args) {
    int opcao = 0;

    do {
      opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
          + "1 - Adicionar cliente na fila\n"
          + "2 - Atender cliente\n"
          + "3 - Mostrar clientes atendidos e na fila\n"
          + "4 - Sair"));

      switch (opcao) {
        case 1:
          adicionarCliente();
          break;
        case 2:
          atenderCliente();
          break;
        case 3:
          mostrarClientes();
          break;
        case 4:
          JOptionPane.showMessageDialog(null, "Saindo do sistema...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opção inválida!");
          break;
      }
    } while (opcao != 4);
  }

  private static void adicionarCliente() {
    String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente:"));
    String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
    double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do cliente:"));

    Civil cliente = new Civil(nome, idade, endereco, salario);
    fila.add(cliente);

    JOptionPane.showMessageDialog(null, "Cliente adicionado na fila!");
  }

  private static void atenderCliente() {
    if (fila.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Não há clientes na fila!");
    } else {
      Pessoa cliente = fila.remove();
      atendidos.add(cliente);

      JOptionPane.showMessageDialog(null, "Cliente atendido: " + cliente.getNome());
    }
  }

  private static void mostrarClientes() {
    StringBuilder clientesAtendidos = new StringBuilder(
        atendidos.isEmpty() ? "Não há clientes atendidos!\n" : "Clientes atendidos:\n");
    for (Pessoa cliente : atendidos) {
      clientesAtendidos.append("Nome: ").append(cliente.getNome()).append("\n");
      clientesAtendidos.append("Idade: ").append(cliente.getIdade()).append("\n");
      clientesAtendidos.append("Endereço: ").append(cliente.getEndereco()).append("\n");
      clientesAtendidos.append("Salário: ").append(cliente.calcularSalario()).append("\n\n");
    }

    StringBuilder divisor = new StringBuilder("-------------------------------------------------------\n");

    StringBuilder clientesFila = new StringBuilder(
        fila.isEmpty() ? "Não há clientes na fila!\n" : "Clientes na fila:\n");
    for (Pessoa cliente : fila) {
      clientesFila.append("Nome: ").append(cliente.getNome()).append("\n");
      clientesFila.append("Idade: ").append(cliente.getIdade()).append("\n");
      clientesFila.append("Endereço: ").append(cliente.getEndereco()).append("\n");
      clientesFila.append("Salário: ").append(cliente.calcularSalario()).append("\n\n");
    }

    JOptionPane.showMessageDialog(null, clientesAtendidos.toString() + divisor + clientesFila.toString());
  }
}