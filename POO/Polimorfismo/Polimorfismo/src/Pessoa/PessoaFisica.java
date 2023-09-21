package Pessoa;
public class PessoaFisica extends Pessoa {

    public PessoaFisica(String nome, int idade) {
        super(nome, idade);
    }
    
    @Override
    public String obterNomeFormatado() {
        return "Dr. " + getNome();
    }
}
