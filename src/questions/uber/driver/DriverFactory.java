package questions.uber.driver;

public class DriverFactory {

  public static Driver build(String name, String mobile, DriverType driverType) {
    if (driverType == DriverType.REGULAR)
      return new RegularDriver(name, mobile);
    else throw new IllegalStateException("Unkown Driver type "+driverType.name());
  }

}
