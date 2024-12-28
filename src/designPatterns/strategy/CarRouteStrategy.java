package designPatterns.strategy;

public class CarRouteStrategy implements RouteStrategy {
  @Override
  public void buildRoute() {
    System.out.print("Build route using CarRouteStrategy");
  }
}
