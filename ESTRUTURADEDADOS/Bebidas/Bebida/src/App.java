import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Bebida bebida = new Bebida();
        ArrayList<Bebida> novaBebidas = new ArrayList<Bebida>();
        int opcao = 0;

        do {
            String escolha = JOptionPane.showInputDialog(
                    "Entrada\n\n" +
                            "0. Cadastro de bebida.\n" +
                            "1. Mostrar a quantidade de bebidas em estoque.\n" +
                            "2. Mostrar o nome da bebida mais cara.\n" +
                            "3. Mostrar a descricao e preco da bebida mais cara. \n" +
                            "4. Mostrar o nome e o preco de venda da bebida mais barata.\n" +
                            "5. Mostrar o nome das bebida com quantidade superior a 30.\n" +
                            "6. Mostrar o nome da bebida com preco entre 4 e 5 reais\n" +
                            "7. Mostrar todos os dados de todas as bebidas.\n" +
                            "8. Exit\n\n" +
                            "Escolha uma opção:");

            if (escolha == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(escolha);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Opção inválida. Por favor, tente novamente.");
                continue;
            }

            switch (opcao) {
                case 0:
                    String nome = JOptionPane.showInputDialog("Digite o nome a bebida:");
                    float custo;
                    try {
                        custo = Float.parseFloat(JOptionPane.showInputDialog("Digite o custo da bebida"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Input invalido. Por favor, tente novamente.");
                        e.printStackTrace();
                        continue;
                    }
                    String descricao = JOptionPane.showInputDialog("Digite a descricao da bebida:");
                    int estoque;
                    try {
                        estoque = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque da bebida:"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Input invalido. Por favor, tente novamente.");
                        e.printStackTrace();
                        continue;
                    }

                    if (nome != null && !nome.isEmpty() && descricao != null && !descricao.isEmpty()) {

                        bebida.setNome(nome);
                        bebida.setCusto(custo);
                        bebida.setDescricao(descricao);
                        bebida.setEstoque(estoque);

                        novaBebidas.add(bebida);
                        System.out.println(novaBebidas.toString());
                        JOptionPane.showMessageDialog(null, "Bebida adicionada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ooops! algo ocorreu errado favor tente denovo");
                    }
                    break;
                case 1:
                    StringBuilder sbBebidaEstoque = new StringBuilder();
                    for (Bebida b : novaBebidas) {
                        sbBebidaEstoque.append("Estoque: ").append(b.getEstoque()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbBebidaEstoque.toString());
                    break;
                case 2:
                    Bebida bebidaCara = null;
                    for (Bebida b : novaBebidas) {
                        if (bebidaCara == null || bebidaCara.getCusto() < b.getCusto()) {
                            bebidaCara = b;
                        }
                    }
                    JOptionPane.showMessageDialog(null, bebidaCara.getNome());
                    break;
                case 3:
                    StringBuilder sbBebidaCara = new StringBuilder();
                    Bebida bebidaCara2 = null;
                    for (Bebida b : novaBebidas) {
                        if (bebidaCara2 == null || bebidaCara2.getCusto() < b.getCusto()) {
                            bebidaCara = b;
                        }
                        sbBebidaCara.append("Custo: ").append(b.getCusto()).append("\n");
                        sbBebidaCara.append("Descricao: ").append(b.getDescricao()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null,sbBebidaCara.toString() );
                    break;
                case 4:
                    StringBuilder sbBebidaNomePrecoVenda = new StringBuilder();
                    Bebida bebidaBarata = null;
                    for (Bebida b : novaBebidas) {
                        if (bebidaBarata == null || bebidaBarata.getCusto() > b.getCusto()) {
                            bebidaBarata = b;
                        }
                        sbBebidaNomePrecoVenda.append("Nome: ").append(b.getNome()).append("\n");
                        sbBebidaNomePrecoVenda.append("Preco de venda: ").append(b.getPrecoVenda()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null,sbBebidaNomePrecoVenda.toString() );
                    break;
                case 5:
                    StringBuilder sbBebidaEstoque30 = new StringBuilder();
                    for (Bebida b : novaBebidas) {
                        if (bebida.getEstoque() > 30) {
                            sbBebidaEstoque30.append(b.getNome()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, sbBebidaEstoque30.toString() );
                    break;
                case 6:
                    StringBuilder sbBebidaPreco = new StringBuilder();
                    for (Bebida b : novaBebidas) {
                        if (b.getCusto() >= 4 && b.getCusto() <= 5) {
                            sbBebidaPreco.append("Nome: ").append(b.getNome()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, sbBebidaPreco.toString() );
                    break;
                case 7:
                    StringBuilder sbBebida = new StringBuilder();
                    for (Bebida b : novaBebidas) {
                        sbBebida.append("Nome: ").append(b.getNome()).append("\n");
                        sbBebida.append("Custo: ").append(b.getCusto()).append("\n");
                        sbBebida.append("Descricao: ").append(b.getDescricao()).append("\n");
                        sbBebida.append("Estoque: ").append(b.getEstoque()).append("\n");
                        sbBebida.append("Preco de venda: ").append(b.getPrecoVenda()).append("\n");
                        sbBebida.append("-----------------------------\n");
                    }
                    JOptionPane.showMessageDialog(null, sbBebida.toString());
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Voltando ao Menu Principal...", "Info",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida. Por favor, tente novamente.");
                    break;
            }

        } while (opcao != 8);
    }
}
