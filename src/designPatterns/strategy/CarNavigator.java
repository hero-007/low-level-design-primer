package designPatterns.strategy;

public class CarNavigator extends Navigator {

  public CarNavigator() {
    super(new CarRouteStrategy());
  }
}
