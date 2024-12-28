package questions.inMemoryRelationDatabase;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
  private final AtomicInteger id = new AtomicInteger(1);

  public int getAndIncrement() {
    return id.getAndIncrement();
  }
}
