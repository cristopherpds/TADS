import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* Pessoa pesoa = new Pessoa();
        pesoa.setNome("Jorge");
        pesoa.setIdade(2);
        System.out.println(pesoa.getNome() + " é " + pesoa.verificarIdade()); */

        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        while (true) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            if (pessoa.setNome(nome)) {
                break;
            } else {
                System.out.println("Nome em branco. Por favor, digite novamente.");
            }
        }

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        pessoa.setIdade(idade);

        System.out.println("Classificação da idade: " + pessoa.verificarIdade());


        //CONTA
        Conta conta = new Conta();

        System.out.print("Digite o saldo a depositar: ");
        float saldoDepositar = scanner.nextFloat();
        conta.deposito(saldoDepositar);

        System.out.println("Saldo atual: " + conta.getSaldo());

        System.out.print("Digite o valor para retirada: ");
        float valorRetirada = scanner.nextFloat();
        scanner.nextLine();
        
        String feedback = conta.retirada(valorRetirada);
        System.out.println(feedback);
        System.out.println("Saldo atual: " + conta.getSaldo());
        scanner.close();
    }
}
