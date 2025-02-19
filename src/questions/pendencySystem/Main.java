package questions.pendencySystem;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    PendencySystem<Integer, String> pendencySystem = new PendencySystem();
    List<String> tags = Arrays.asList("Upi", "Karnataka", "Bangalore");
    pendencySystem.startTracking(1112, tags);

    List<String> tags2 = Arrays.asList("Upi", "Karnataka", "Mysore");
    pendencySystem.startTracking(2451, tags2);

    List<String> tags3 = Arrays.asList("Upi", "Rajasthan", "Jaipur");
    pendencySystem.startTracking(3421, tags3);

    Long count = pendencySystem.getCount(Arrays.asList("Upi", "Karnataka"));
    System.out.println(count);
  }
}
