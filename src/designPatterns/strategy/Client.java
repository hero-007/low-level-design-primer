package designPatterns.strategy;

public class Client {

  public static void main(String[] args) {
    Navigator carNavigator = new CarNavigator();
    carNavigator.buildRoute();

    RouteStrategy bikeStrategy = new BikeRouteStrategy();
    carNavigator.changeStrategy(bikeStrategy);
    carNavigator.buildRoute();
  }
}
