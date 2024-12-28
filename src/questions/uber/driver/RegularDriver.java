package questions.uber.driver;

import questions.uber.allocation.IntraCityRideAllocationEngine;
import questions.uber.ride.Ride;
import questions.uber.wallet.DriverWallet;
import questions.uber.wallet.RegularDriverWallet;

import java.util.ArrayList;
import java.util.List;

public class RegularDriver implements Driver {
  private String name;
  private String mobile;
  private List<Ride> rideHistory;
  private DriverWallet wallet;

  RegularDriver(String name, String mobile) {
    this.name = name;
    this.wallet = new RegularDriverWallet();
    this.rideHistory = new ArrayList<>();
    this.mobile = mobile;

    // Register the driver with the allocation engine
    IntraCityRideAllocationEngine.registerDriver(this);
  }

  @Override
  public void acceptRide(Ride ride) {
    // 1 - Let driver accept the ride
    // 2 - Add ride to driver's ride history
    ride.accept(this);
    rideHistory.add(ride);
  }

  @Override
  public void denyRide(Ride ride) {
    // 1 - Let driver deny the ride
    ride.deny(this);
  }

  @Override
  public void startRide(Ride ride) {
    // 1 - Let driver start the ride
    ride.start();
  }

  @Override
  public void completeRide(Ride ride) {
    // 1 - Let driver complete the ride
    ride.complete();
  }

  @Override
  public void sendNotification(String message) {
    // 1 - Send notification to driver
    System.out.println(message);
  }

  @Override
  public void withdrawMoney(Double amount) {
    // 1 - Let driver withdraw money from his/her wallet
    wallet.withdraw(amount);
  }

  @Override
  public void acceptPayment(Double amount) {
    // 1 - Let driver accept payment for the ride
    wallet.deposit(amount);
  }
}
