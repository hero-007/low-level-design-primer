package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
  private static final AtomicInteger idCounter = new AtomicInteger(0);

  public static int generateId() {
    return idCounter.getAndIncrement();
  }
}
