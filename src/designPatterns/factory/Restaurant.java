package designPatterns.factory;

public class Restaurant {

  public static void main(String[] args) {
    PizzaFactory.makePizza(PizzaType.AMERICAN).serve();
    PizzaFactory.makePizza(PizzaType.INDIAN).serve();
    PizzaFactory.makePizza(PizzaType.ITALIAN).serve();
  }
}
