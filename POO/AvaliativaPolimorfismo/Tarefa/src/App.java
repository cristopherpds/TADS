import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Crie uma estrutura de classes(todas com apenas um contrutor que receba todos
         * os dados) onde a classe abstrata seja Pessoa, com os atributos nome, idade e
         * endereco com todos os Gets&Sets.
         * 
         * Crie as classes filhas Gerente, Programador e Vendedor, todas com o atributo
         * salario e o Gets&Sets. Implemente o metodo calculaSalario que respeite a
         * tabela abaixo:
         * Gerente recebe 20% de acréscimo no valor do salario total;
         * Programador recebe 10% de acréscimo no valor do salario total;
         * Vendedor recebe 30% de acréscimo no valor do salario total.
         *
         * Será necessário alterar a classe Pessoa para mostrar os atributos que não
         * pertençam a ela no ArrayList.
         * 
         * Crie um objeto de cada classe e armazene-as em um arrayList de Pessoa.
         * Preencha os dados de forma hardCode. Através de um laço for compactado,
         * percorra o arraylist e mostre todos os
         * dados(nome,Idade,endereço,salarionormal, salarioComAcréscimo(método
         * calcularSalario)).
         */

        PessoaGerente gerente = new PessoaGerente("João", 30, "Rua 1", 1000);
        PessoaProgamador programador = new PessoaProgamador("Maria", 25, "Rua 2", 1000);
        PessoaVendedor vendedor = new PessoaVendedor("José", 20, "Rua 3", 1000);

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(gerente);
        pessoas.add(programador);
        pessoas.add(vendedor);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
            System.out.println("Salário com acréscimo: " + pessoa.calcularSalario());
        }

    }
}
