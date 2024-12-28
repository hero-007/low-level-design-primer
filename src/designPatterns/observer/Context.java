package designPatterns.observer;

public class Context {
  private Integer orderId;
  private OrderStatus orderStatus;

  public Context(Integer orderId, OrderStatus orderStatus) {
    this.orderId = orderId;
    this.orderStatus = orderStatus;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }
}
