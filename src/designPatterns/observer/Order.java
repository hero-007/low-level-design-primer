package designPatterns.observer;

import java.net.ConnectException;
import java.time.Instant;
import utils.IdGenerator;

public class Order {
  private Integer id;
  private OrderStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  private EventManager eventManager;

  public Order() {
    this.id = IdGenerator.generateId();
    this.status = OrderStatus.OPEN;
    createdAt = Instant.now();
    updatedAt = Instant.now();

    eventManager = new EventManager();
  }

  public void start() {
    status = OrderStatus.INPROGRESS;
    updatedAt = Instant.now();

    notifySubscribers();
  }

  public void complete() {
    status = OrderStatus.COMPLETED;
    updatedAt = Instant.now();

    notifySubscribers();
  }

  public void cancel() {
    status = OrderStatus.CANCELLED;
    updatedAt = Instant.now();

    notifySubscribers();
  }

  private void notifySubscribers() {
    Context context = buildContext();
    eventManager.notifyAll(context);
  }

  private Context buildContext() {
    return new Context(id, status);
  }

  public EventManager getEventManager() {
    return eventManager;
  }
}
