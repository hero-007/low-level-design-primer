package questions.uber.fare;

import java.util.HashMap;
import java.util.Map;

public class FareComponentDescription {
  private static Map<FareComponentType, String> fareComponentDescriptionMap;

  static {
    fareComponentDescriptionMap = new HashMap<>();

    fareComponentDescriptionMap.put(FareComponentType.BASE_FARE, "Base fare that would charged for the trip.");
    fareComponentDescriptionMap.put(FareComponentType.DISTANCE_CHARGES, "Per KM Charges computed for the trip");
    fareComponentDescriptionMap.put(FareComponentType.ADDITIONAL_CHARGES, "Covers additional charges like toll, night charges etc.");
    fareComponentDescriptionMap.put(FareComponentType.TOTAL_FARE, "Total amount for the trip , including all the charges.");
  }

  public static String get(FareComponentType type) {
    if (!fareComponentDescriptionMap.containsKey(type))
      throw new IllegalStateException("No description found for fare component type "+type);

    return fareComponentDescriptionMap.get(type);
  }
}
