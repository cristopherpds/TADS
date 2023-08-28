import java.util.ArrayList;

public class Programa2 {
  public static void main(String[] args) {
    ArrayList<String> nomes = new ArrayList<>();

    nomes.add("Cristopher");
    nomes.add("Pedro");
    nomes.add("Carol");


    if (nomes.size() >= 2) {
      nomes.remove(1); 
    }

    System.out.println("Nomes no ArrayList:");
    for (String nome : nomes) {
      System.out.println(nome);
    }
  }
}
