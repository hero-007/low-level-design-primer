package designPatterns.factory;

public class AmericanPizza implements Pizza{
  @Override
  public void serve() {
    System.out.println("Serve American Pizza");
  }
}
