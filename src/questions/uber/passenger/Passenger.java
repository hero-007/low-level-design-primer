package questions.uber.passenger;

import questions.uber.ride.Ride;
import questions.uber.ride.RideType;

import java.util.List;

public interface Passenger {
  Ride bookRide(String pickup, String drop, RideType type);
  void cancelRide(Ride ride);
  List<Ride> getRideHistory();
  void sendNotification(String message);
  void rechargeWallet(Double amount);
  void payForRide(Double amount);
}
