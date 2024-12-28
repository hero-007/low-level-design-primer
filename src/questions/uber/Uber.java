package questions.uber;

import questions.uber.driver.Driver;
import questions.uber.driver.DriverFactory;
import questions.uber.driver.DriverType;
import questions.uber.passenger.Passenger;
import questions.uber.passenger.PassengerFactory;
import questions.uber.passenger.PassengerType;
import questions.uber.ride.Ride;
import questions.uber.ride.RideType;

public class Uber {

  public static void main(String[] args) {
    Passenger p1 = PassengerFactory.build(PassengerType.REGULAR, "Akhil", "8449689598");
    Passenger p2 = PassengerFactory.build(PassengerType.REGULAR, "Vaibhav", "8077784234");

    Driver d1 = DriverFactory.build("Driver Akhil", "8449689598", DriverType.REGULAR);
    Driver d2 = DriverFactory.build("Driver Vaibhav", "8077784234", DriverType.REGULAR);

    p1.rechargeWallet(10000.0);
    p2.rechargeWallet(5000.0);

    Ride p1Ride = p1.bookRide("HSR", "BTM", RideType.INTRA_CITY);

    d1.acceptRide(p1Ride);
    d1.startRide(p1Ride);
    d1.completeRide(p1Ride);

    System.out.println("Ride completed");
  }
}
