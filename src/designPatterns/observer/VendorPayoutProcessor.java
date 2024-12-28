package designPatterns.observer;

public class VendorPayoutProcessor implements Subscriber{

  @Override
  public void processNotification(Context context) {
    int orderId = context.getOrderId();

    switch (context.getOrderStatus()) {
      case COMPLETED:
        System.out.println("Generate vendor order payout for order: " + orderId);
        break;
    }
  }
}
