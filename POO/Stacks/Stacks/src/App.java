import java.util.Stack;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Stack<Pessoa> pilhaPessoas = new Stack<>();

        Pessoa pessoa1 = new Pessoa("João", 30);
        Pessoa pessoa2 = new Pessoa("Maria", 25);
        Pessoa pessoa3 = new Pessoa("Carlos", 35);
        Pessoa pessoa4 = new Pessoa("Ana", 28);
        Pessoa pessoa5 = new Pessoa("Pedro", 22);


        pilhaPessoas.push(pessoa1);
        pilhaPessoas.push(pessoa2);
        pilhaPessoas.push(pessoa3);
        pilhaPessoas.push(pessoa4);
        pilhaPessoas.push(pessoa5);


        StringBuilder mensagem = new StringBuilder("Dados das pessoas:\n");
        for (Pessoa pessoa : pilhaPessoas) {
            mensagem.append(pessoa.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());

        if (!pilhaPessoas.isEmpty()) {
            pilhaPessoas.pop();
        }

        if (!pilhaPessoas.isEmpty()) {
            pilhaPessoas.pop();
        }

        mensagem = new StringBuilder("Pilha após retirar 2 elementos:\n");
        for (Pessoa pessoa : pilhaPessoas) {
            mensagem.append(pessoa.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
}
