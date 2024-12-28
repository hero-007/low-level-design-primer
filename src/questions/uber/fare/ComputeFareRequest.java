package questions.uber.fare;

import questions.uber.passenger.Passenger;
import questions.uber.ride.RideType;

public class ComputeFareRequest {
  private String pickup;
  private String drop;
  private RideType rideType;
  private Passenger passenger;

  public ComputeFareRequest(String pickup, String drop, RideType rideType, Passenger passenger) {
    this.pickup = pickup;
    this.drop = drop;
    this.rideType = rideType;
    this.passenger = passenger;
  }

  public String getPickup() {
    return pickup;
  }

  public void setPickup(String pickup) {
    this.pickup = pickup;
  }

  public String getDrop() {
    return drop;
  }

  public void setDrop(String drop) {
    this.drop = drop;
  }

  public RideType getRideType() {
    return rideType;
  }

  public void setRideType(RideType rideType) {
    this.rideType = rideType;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }
}
