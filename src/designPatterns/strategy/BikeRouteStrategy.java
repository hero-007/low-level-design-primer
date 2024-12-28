package designPatterns.strategy;

public class BikeRouteStrategy implements RouteStrategy {

  @Override
  public void buildRoute() {
    System.out.println("Build route using BikeRouteStrategy");
  }

}
