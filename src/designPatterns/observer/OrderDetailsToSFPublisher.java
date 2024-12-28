package designPatterns.observer;

public class OrderDetailsToSFPublisher implements Subscriber{

  @Override
  public void processNotification(Context context) {
    int orderId = context.getOrderId();

    switch (context.getOrderStatus()) {
      case OPEN:
        System.out.println("Publish open order details to SF for orderID: " + orderId);
        break;
      case INPROGRESS:
        System.out.println("Publish inprogress order details to SF for orderID: " + orderId);
        break;
      case CANCELLED:
        System.out.println("Publish cancelled order details to SF for orderID: " + orderId);
        break;
      case COMPLETED:
        System.out.println("Publish completed order details to SF for orderID: " + orderId);
        break;

      default:
        throw new IllegalStateException("Unknown order state");
    }
  }
}
