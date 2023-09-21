package Mamiferos;

public class Gato extends Mamiferos {
  public Gato() {
    super("Miau", "Gato");
  }

  @Override
  public String som() {
    return "Miau";
  }
}
