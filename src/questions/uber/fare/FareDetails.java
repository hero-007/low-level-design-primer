package questions.uber.fare;

import java.util.List;
import java.util.NoSuchElementException;

public class FareDetails {
  private static final float UBER_COMMISION_RATE = 0.15f;
  private List<FareComponent> fareComponents;

  public FareDetails(List<FareComponent> fareComponents) {
    this.fareComponents = fareComponents;
  }

  public Double computeDriverShare() {
    Double commission = computeCommission();

    return getFareComponent(FareComponentType.TOTAL_FARE).getAmountInRs() - commission;
  }

  public Double computeCommission() {
    FareComponent totalFareComponent = getFareComponent(FareComponentType.TOTAL_FARE);
    return totalFareComponent.getAmountInRs() * UBER_COMMISION_RATE;
  }

  public Double getTotalFare() {
    FareComponent totalFareComponent = getFareComponent(FareComponentType.TOTAL_FARE);
    return totalFareComponent.getAmountInRs();
  }

  private FareComponent getFareComponent(FareComponentType type) {
    return fareComponents.stream()
      .filter(fareComponent -> fareComponent.getType() == type)
      .findFirst()
      .orElseThrow(() -> new NoSuchElementException("No "+ type.name() +" component found"));
  }
}
