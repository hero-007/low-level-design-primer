package designPatterns.strategy;

public class WalkingRouteStrategy implements RouteStrategy {

  @Override
  public void buildRoute() {
    System.out.print("Build route using WalkingRouteStrategy");
  }

}
