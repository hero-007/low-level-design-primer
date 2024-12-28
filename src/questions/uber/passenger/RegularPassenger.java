package questions.uber.passenger;

import questions.uber.fare.ComputeFareRequest;
import questions.uber.fare.FareDetails;
import questions.uber.fare.FareSystem;
import questions.uber.ride.*;
import questions.uber.wallet.PassengerWallet;
import questions.uber.wallet.RegularPassengerWallet;

import java.util.ArrayList;
import java.util.List;

public class RegularPassenger implements Passenger {
  private String mobile;
  private String name;
  private List<Ride> rideHistory;
  private PassengerWallet wallet;

  public RegularPassenger(String mobile, String name) {
    this.mobile = mobile;
    this.name = name;
    rideHistory = new ArrayList<>();
    wallet = new RegularPassengerWallet();
  }

  @Override
  public Ride bookRide(String pickup, String drop, RideType type) {
    // 1 - Compute the Ride fare
    // 2 - Create a Ride
    // 3 - Add Ride to ride history
    ComputeFareRequest computeFareRequest = new ComputeFareRequest(pickup, drop, type, this);
    FareDetails fareDetails = FareSystem.computeFare(computeFareRequest);

    BookRideRequest bookRideRequest = new BookRideRequest(pickup, drop, this, fareDetails, type);
    Ride ride = RideFactory.build(bookRideRequest);

    rideHistory.add(ride);

    return ride;
  }

  @Override
  public void cancelRide(Ride ride) {
    // 1 - Cancel the Ride
    // 2 - Notify driver that ride has been cancelled
    ride.cancel();
  }

  @Override
  public List<Ride> getRideHistory() {
    return rideHistory;
  }

  @Override
  public void sendNotification(String message) {
    // 1 - Send notification to the passenger
    System.out.println(message);
  }

  @Override
  public void rechargeWallet(Double amount) {
    wallet.recharge(amount);
  }

  @Override
  public void payForRide(Double amount) {
    wallet.pay(amount);
  }
}
