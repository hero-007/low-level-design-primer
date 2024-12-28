package questions.uber.passenger;

public class PassengerFactory {

  public static Passenger build(PassengerType type, String mobile, String name) {
    if (type == PassengerType.REGULAR)
      return new RegularPassenger(mobile, name);
    else throw new IllegalStateException("Unknown passenger type "+type);
  }

}
