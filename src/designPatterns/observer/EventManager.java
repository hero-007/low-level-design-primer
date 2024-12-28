package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
  private List<Subscriber> subscribers;

  public EventManager() {
    subscribers = new ArrayList<>();
  }

  public void subscribe(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void unsubscribe(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }

  public void notifyAll(Context context) {
    subscribers.forEach(subscriber -> subscriber.processNotification(context));
  }
}
