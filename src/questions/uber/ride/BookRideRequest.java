package questions.uber.ride;

import questions.uber.fare.FareDetails;
import questions.uber.passenger.Passenger;

public class BookRideRequest {
  private String pickup;
  private String drop;
  private Passenger passenger;
  private FareDetails fareDetails;
  private RideType rideType;

  public BookRideRequest(String pickup, String drop, Passenger passenger, FareDetails fareDetails, RideType type) {
    this.pickup = pickup;
    this.drop = drop;
    this.passenger = passenger;
    this.fareDetails = fareDetails;
    this.rideType = type;
  }

  public RideType getRideType() {
    return rideType;
  }

  public void setRideType(RideType rideType) {
    this.rideType = rideType;
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

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public FareDetails getFareDetails() {
    return fareDetails;
  }

  public void setFareDetails(FareDetails fareDetails) {
    this.fareDetails = fareDetails;
  }
}
