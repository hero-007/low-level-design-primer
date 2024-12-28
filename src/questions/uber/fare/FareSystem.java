package questions.uber.fare;

import java.util.ArrayList;
import java.util.List;

public class FareSystem {
  private static final Double BASE_FARE = 700.0;

  public static FareDetails computeFare(ComputeFareRequest request) {
    List<FareComponent> fareComponents = new ArrayList<>();
    FareComponent distanceCharges = computeDistanceCharges(request);

    fareComponents.add(new FareComponent(FareComponentType.BASE_FARE, BASE_FARE));
    fareComponents.add(distanceCharges);

    Double totalFare = 0.0;

    for (FareComponent component: fareComponents) {
      totalFare += component.getAmountInRs();
    }

    fareComponents.add(new FareComponent(FareComponentType.TOTAL_FARE, totalFare));

    FareDetails fareDetails = new FareDetails(fareComponents);
    return fareDetails;
  }

  private static FareComponent computeDistanceCharges(ComputeFareRequest request) {
    return new FareComponent(FareComponentType.DISTANCE_CHARGES, 500.0);
  }
}
