package designPatterns.observer;

public class OLCCommunicationHandler implements Subscriber {

  @Override
  public void processNotification(Context context) {
    int orderId = context.getOrderId();

    switch (context.getOrderStatus()) {
      case OPEN:
        System.out.println("Send open order notification for orderID: "+orderId);
        break;
      case INPROGRESS:
        System.out.println("Send inprogess order notification for orderID: "+orderId);
        break;
      case CANCELLED:
        System.out.println("Send cancelled order notification for orderID: "+orderId);
        break;
      case COMPLETED:
        System.out.println("Send completed order notification for orderID: "+orderId);
        break;

      default: throw new IllegalStateException("Unknown order state");
    }
  }
}
