import java.util.ArrayList;

public class Programa4 {
  public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Pedro", 25));
        pessoas.add(new Pessoa("Cristopher", 30));
        pessoas.add(new Pessoa("Carol", 28));


        int somaIdades = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            somaIdades += pessoa.getIdade();
        }

        System.out.println("A soma das idades na lista é: " + somaIdades);
    }
}
