package questions.ticTacToe;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
  private static AtomicInteger id = new AtomicInteger();

  public static Integer generateId() {
    return id.getAndIncrement();
  }
}
