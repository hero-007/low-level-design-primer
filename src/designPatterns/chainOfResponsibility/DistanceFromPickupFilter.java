package designPatterns.chainOfResponsibility;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DistanceFromPickupFilter extends BaseFilter {
  private final String NAME = "DistanceFromPickupFilter";
  private final Double MAX_DISTANCE_FROM_PICKUP_MTRS = 10000.0;

  @Override
  public void run(FilterContext context) {
    List<Integer> inputVendors = context.getResponse();
    ConcurrentHashMap<Integer, Double> vendorIdToDistanceFromPickupMap = context.getRequest().getVendorIdToDistanceFromPickupMap();

    List<Integer> outputVendors = inputVendors.stream()
      .filter(vendorId -> vendorIdToDistanceFromPickupMap.getOrDefault(vendorId, Double.MAX_VALUE) < MAX_DISTANCE_FROM_PICKUP_MTRS)
      .collect(Collectors.toList());

    List<Integer> filteredVendors = inputVendors.stream()
      .filter(v -> !outputVendors.contains(v))
      .collect(Collectors.toList());

    FilterResponse response = new FilterResponse(NAME, inputVendors, filteredVendors, outputVendors);

    context.addFilterResponse(response);
    context.setResponse(outputVendors);
    super.run(context);
  }

}
