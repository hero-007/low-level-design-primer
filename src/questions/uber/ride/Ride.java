package questions.uber.ride;

import questions.uber.driver.Driver;

public interface Ride {
  void accept(Driver driver);
  void deny(Driver driver);
  void start();
  void complete();
  void cancel();
}
