package designPatterns.observer;

public class Client {

  public static void main(String[] args) {
    Order firstOrder = new Order();
    addSubscriber(firstOrder);
    firstOrder.start();
    firstOrder.complete();

    Order secondOrder = new Order();
    addSubscriber(secondOrder);
    secondOrder.start();
    secondOrder.cancel();
  }

  private static void addSubscriber(Order order) {
    Subscriber olcCommunicationSubscriber = new OLCCommunicationHandler();
    Subscriber publishDetailsToSFSubscriber = new OrderDetailsToSFPublisher();
    Subscriber vendorPayoutProcessorSubscriber = new VendorPayoutProcessor();

    order.getEventManager().subscribe(olcCommunicationSubscriber);
    order.getEventManager().subscribe(publishDetailsToSFSubscriber);
    order.getEventManager().subscribe(vendorPayoutProcessorSubscriber);
  }
}
