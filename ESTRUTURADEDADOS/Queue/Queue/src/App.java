import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> fila = new LinkedList<>();

        System.out.println("Fila de numeros inteiros de 1 a 10");
        for (int i = 1; i <= 10; i++) {
            fila.add(i);
            System.out.println(i);
        }
        System.out.println("\n");

        System.out.println("Removendo os 4 primeiros numeros da fila");
        for (int i = 0; i < 4; i++) {
            int numero = fila.remove();
            System.out.println(numero);
        }
    }
}
