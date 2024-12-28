package designPatterns.chainOfResponsibility;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WalletBalanceFilter extends BaseFilter {
  private final String NAME = "WalletBalanceFilter";
  private final Double MIN_WALLET_BALANCE = 1000.0;

  @Override
  public void run(FilterContext context) {
    List<Integer> inputVendors = context.getResponse();
    ConcurrentHashMap<Integer, Double> vendorIdToWalletBalanceMap = context.getRequest().getVendorIdToWalletBalanceMap();

    List<Integer> outputVendors = inputVendors.stream()
      .filter(vendorId -> vendorIdToWalletBalanceMap.getOrDefault(vendorId, 0.0) > MIN_WALLET_BALANCE)
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
