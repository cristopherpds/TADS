import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String nome;
    private double custo;
    private String validade;
    private int quantidade;

    public Item(String nome, double custo, int quantidade) {
        this.nome = nome;
        this.custo = custo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public String getValidade() {
        return validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularValorVenda() {
        return custo + 0.3 * custo;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Item> estoque = new ArrayList<>();
        StringBuilder sbEstoque = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de estoque!");

        while (true) {
            System.out.print("Digite o nome do produto (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();
            
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o custo do produto: ");
            double custo = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a quantidade do produto: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            estoque.add(new Item(nome, custo, quantidade));
        }

        for (Item item : estoque) {
            sbEstoque.append("Nome: " + item.getNome() + "\n");
            sbEstoque.append("Custo: " + item.getCusto() + "\n");
            sbEstoque.append("Quantidade: " + item.getQuantidade() + "\n");
            sbEstoque.append("Valor de venda: " + item.calcularValorVenda() + "\n");
            sbEstoque.append("\n");
        }

        System.out.println("Estoque cadastrado com sucesso:");
        System.out.println(sbEstoque.toString());
        scanner.close();
    }
}
