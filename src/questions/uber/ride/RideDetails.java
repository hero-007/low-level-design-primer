package questions.uber.ride;

import java.util.UUID;

public class RideDetails {
  private String crn;
  private String pickup;
  private String drop;
  private RideType type;

  public RideDetails(String pickup, String drop, RideType type) {
    this.crn = UUID.randomUUID().toString().substring(1, 10);
    this.pickup = pickup;
    this.drop = drop;
    this.type = type;
  }

  public String getCrn() {
    return crn;
  }

  public String getPickup() {
    return pickup;
  }

  public String getDrop() {
    return drop;
  }

  public RideType getType() {
    return type;
  }
}
