package designPatterns.strategy;

public class BusRouteStrategy implements RouteStrategy {

  @Override
  public void buildRoute() {
    System.out.println("Build route using BusRouteStrategy");
  }

}
