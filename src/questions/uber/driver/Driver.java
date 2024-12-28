package questions.uber.driver;

import questions.uber.ride.Ride;

public interface Driver {
  void acceptRide(Ride ride);
  void denyRide(Ride ride);
  void startRide(Ride ride);
  void completeRide(Ride ride);

  void sendNotification(String message);

  void withdrawMoney(Double amount);
  void acceptPayment(Double amount);
}
