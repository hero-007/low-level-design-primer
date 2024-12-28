package designPatterns.factory;

public class IndianPizza implements Pizza{
  @Override
  public void serve() {
    System.out.println("Serve Indian Pizza");
  }
}
