import java.util.ArrayList;

public class Programa1 {
  public static void main(String[] args) {
    ArrayList<Integer> numeros = new ArrayList<>();


        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        System.out.println("Números no ArrayList:");
        for (int numero : numeros) {
            System.out.println(numero);
        }
  }
}