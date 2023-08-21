public class Aula2 {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        Cachorro cachorro = new Cachorro();
        ContaBancaria contaBancaria = new ContaBancaria();

        //Create Pessoa
        pessoa.setNome("Jorge");
        pessoa.setIdade(18);
        pessoa.setQuantVida(100);
        pessoa.setHabilidadeParaAtirar(60);

        System.out.println(pessoa.toString());

        //Create Cachorro
        cachorro.setNome("Drupi");
        cachorro.setIdade(9);
        cachorro.setQuantVida(100);
        cachorro.setCorDoPelo("Branco");
        cachorro.setForcaDaMordida(80);

        System.out.println(cachorro.toString());

        //Create Conta Bancaria
        contaBancaria.setTitular("Jorge");
        contaBancaria.setNumeroConta(1234);
        contaBancaria.setSaldo(1000);
        contaBancaria.setContaAtiva(false);
        contaBancaria.setSeguranca(50);

        System.out.println(contaBancaria.toString());
    
        //Acoes
        contaBancaria.mostrarSaldo();
        contaBancaria.sacar(200);
        
        pessoa.jogarBolaComCachorro(cachorro);
        pessoa.realizarTransacao(contaBancaria, 100);
        cachorro.latir();
    }
}
