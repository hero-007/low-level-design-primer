package questions.uber.ride;

import questions.uber.allocation.IntraCityRideAllocationEngine;
import questions.uber.driver.Driver;
import questions.uber.fare.FareDetails;
import questions.uber.passenger.Passenger;

public class RegularRide implements Ride {
  private RideDetails rideDetails;
  private Passenger passenger;
  private Driver driver;
  private FareDetails fareDetails;
  private RideStatus status;

  RegularRide(BookRideRequest bookRideRequest) {
    this.rideDetails = new RideDetails(bookRideRequest.getPickup(), bookRideRequest.getDrop(), bookRideRequest.getRideType());
    this.passenger = bookRideRequest.getPassenger();
    this.fareDetails = bookRideRequest.getFareDetails();
    this.driver = null;
    this.status = RideStatus.OPEN;

    // Start the allocation of this ride
    IntraCityRideAllocationEngine.allocate(this);
  }

  @Override
  public void accept(Driver driver) {
    // 1 - Assign driver to the ride
    // 2 - Update the status of the ride
    // 3 - Send ride accepted notification to the customer along with driver details
    if (this.driver != null)
      throw new IllegalStateException("Ride is already accepted by someone else");

    this.driver = driver;
    this.status = RideStatus.ACCEPTED;

    String passengerNotification = "Your ride "+rideDetails.getCrn()+" has been accepted.";
    passenger.sendNotification(passengerNotification);
  }

  @Override
  public void deny(Driver driver) {
    // 1 - Log the details of driver who has denied the ride
    System.out.println(driver);
  }

  @Override
  public void start() {
    // 1 - Update the ride status
    // 2 - send ride started notification to the customer
    if (status != RideStatus.ACCEPTED)
      throw new IllegalStateException("Ride has to be ACCEPTED state to start the ride");

    if(driver == null)
      throw new IllegalStateException("No driver has accepted this ride");

    status = RideStatus.STARTED;

    String passengerNotification = "Your ride "+rideDetails.getCrn()+" has been started.";
    passenger.sendNotification(passengerNotification);
  }

  @Override
  public void complete() {
    // 1 - Update the status of the ride
    // 2 - Transfer the money to drivers wallet after deducting the commision
    // 3 - Send notification to the customer
    if (status != RideStatus.STARTED)
      throw new IllegalStateException("Ride has to be started before it can be marked as completed");

    status = RideStatus.COMPLETED;

    Double totalFare = fareDetails.getTotalFare();
    passenger.payForRide(totalFare);

    Double driverPayment = fareDetails.computeDriverShare();
    driver.acceptPayment(driverPayment);

    String passengerNotification = "Your order "+rideDetails.getCrn()+" has been successfully completed";
    passenger.sendNotification(passengerNotification);
  }

  @Override
  public void cancel() {
    // 1 - Update the status of the ride
    // 2 - Send notification to the customer
    if (status == RideStatus.COMPLETED)
      throw new IllegalStateException("Ride once completed cannot be cancelled");

    status = RideStatus.CANCELLED;

    String passengerNotification = "Your order "+rideDetails.getCrn()+" has been cancelled";
    passenger.sendNotification(passengerNotification);
  }
}
