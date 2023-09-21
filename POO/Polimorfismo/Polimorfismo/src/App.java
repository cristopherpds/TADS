import java.util.ArrayList;

import Mamiferos.Baleia;
import Mamiferos.Cachorro;
import Mamiferos.Elefante;
import Mamiferos.Gato;
import Mamiferos.Leao;
import Mamiferos.Macaco;
import Mamiferos.Mamiferos;

import Pessoa.Pessoa;
import Pessoa.PessoaFisica;
import Pessoa.PessoaJuridica;

public class App {

    /*
     * Respostas das questões 1 e 2
     * 1) Polimorfismo é a capacidade de um objeto ser referenciado
     * de diferentes formas, ou seja, um mesmo objeto pode ser tratado como se fosse
     * de diferentes tipos.
     * 2) Polimorfismo estático ocorre em tempo de compilação, onde o tipo
     * da referência é usado para determinar qual método será chamado.
     * Já o polimorfismo dinâmico ocorre em tempo de execução, onde o tipo
     * real do objeto é usado para determinar qual método será chamado.
     */

    public static void main(String[] args) throws Exception {
        ArrayList<Mamiferos> animais = new ArrayList<>();
        animais.add(new Cachorro());
        animais.add(new Gato());
        animais.add(new Baleia());
        animais.add(new Elefante());
        animais.add(new Leao());
        animais.add(new Macaco());

        for (Mamiferos animal : animais) {
            System.out.println("\nO animal que faz o som: " + animal.som() + " é: " + animal.nome() + "\n");
        }

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica("João", 23));
        pessoas.add(new PessoaFisica("Maria", 35));
        pessoas.add(new PessoaFisica("Pedro", 18));
        pessoas.add(new PessoaFisica("Ana", 27));
        pessoas.add(new PessoaFisica("Lucas", 52  ));
        pessoas.add(new PessoaJuridica("João Enrrique", 30 ));
        pessoas.add(new PessoaJuridica("Carlos Albero", 25 ));
        pessoas.add(new PessoaJuridica("Simas Turbo", 33 ));
        pessoas.add(new PessoaJuridica("Jalim Rabei", 45 ));
        pessoas.add(new PessoaJuridica("Elvio Lador", 65 ));
        pessoas.add(new PessoaFisica("José", 66));
        pessoas.add(new PessoaFisica("Carla", 58 ));
        pessoas.add(new PessoaFisica("Rafael",25 ));
        pessoas.add(new PessoaFisica("Mariana", 18));
        pessoas.add(new PessoaFisica("Fernanda",36 ));

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
    }
    
    /*
     * Ao criar objetos de PessoaFisica e PessoaJuridica e armazena-los em um
     * ArrayList de Pessoa, podemos percorrer esse ArrayList e chamar o método
     * polimórfico getNome em cada objeto, que retorna o nome da pessoa formatado
     * de acordo com o tipo de pessoa (física ou jurídica). Concluímos que o
     * polimorfismo
     * permite que objetos de diferentes classes sejam tratados de forma uniforme,
     * facilitando a manutenção e a extensão do código.
     */
}
