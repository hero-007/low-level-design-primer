package designPatterns.factory;

public class ItalianPizza implements Pizza {
  @Override
  public void serve() {
    System.out.println("Serve Italian Pizza");
  }
}
