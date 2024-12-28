package questions.uber.allocation;

import questions.uber.driver.Driver;
import questions.uber.ride.Ride;

import java.util.ArrayList;
import java.util.List;

public class IntraCityRideAllocationEngine {
  private static List<Driver> drivers;

  static {
    drivers = new ArrayList<>();
  }

  public static void registerDriver(Driver driver) {
    drivers.add(driver);

    String message = "You've been successfully registered for accepting new rides";
    driver.sendNotification(message);
  }

  public static void allocate(Ride ride) {
    String message = "New ride available near you";
    drivers.forEach(driver -> driver.sendNotification(message));
  }

}
