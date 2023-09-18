import java.util.Stack;

public class Pilha {
  public static void main(String[] args) {
    Stack<Integer> pilha = new Stack<Integer>();

    for (int i = 0; i < 10; i++) {
      pilha.push(i);
    }

    while (!pilha.isEmpty()) {
      System.out.println(pilha.pop());
    }
  }
}
