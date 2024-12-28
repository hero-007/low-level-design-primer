package questions.uber.ride;

public class RideFactory {

  public static Ride build(BookRideRequest request) {
    if (request.getRideType() == RideType.INTRA_CITY)
      return new RegularRide(request);

    else throw new IllegalStateException("Unknown ride type "+request.getRideType());
  }
}
