package Pessoa;
public class PessoaJuridica extends Pessoa {
    public PessoaJuridica(String nome, int idade) {
        super(nome, idade);
    }
    @Override
    public String obterNomeFormatado(){
        return getNome();
    }

    @Override
    public int getIdade() {
        return super.getIdade() + 100;
    }
}
