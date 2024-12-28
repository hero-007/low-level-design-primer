package designPatterns.strategy;

public abstract class Navigator {
  private RouteStrategy routeStrategy;

  public Navigator(RouteStrategy routeStrategy) {
    this.routeStrategy = routeStrategy;
  }

  public void buildRoute() {
    routeStrategy.buildRoute();
  }
  public void changeStrategy(RouteStrategy routeStrategy) {this.routeStrategy = routeStrategy;}
}
