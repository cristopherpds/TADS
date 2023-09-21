package Mamiferos;

public class Macaco extends Mamiferos {
  public Macaco() {
    super("Grito", "Macaco");
  }

  @Override
  public String som() {
    return "Grito";
  }
}
