package designPatterns.factory;

public class PizzaFactory {

  public static Pizza makePizza(PizzaType type) {
    if (type == PizzaType.INDIAN)
      return new IndianPizza();
    else if (type == PizzaType.AMERICAN)
      return new AmericanPizza();
    else if(type == PizzaType.ITALIAN)
      return new ItalianPizza();
    else throw new IllegalStateException("Unkown pizza type "+type.name());
  }
}
