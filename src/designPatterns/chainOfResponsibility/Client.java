package designPatterns.chainOfResponsibility;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Client {

  public static void main(String[] args) {
    List<Integer> inputVendors = Arrays.asList(1, 2, 3, 4);
    FilterRequest filterRequest = buildFilterRequest();
    FilterContext filterContext = new FilterContext(filterRequest, inputVendors);

    Filter walletBalanceFilter = new WalletBalanceFilter();
    Filter distanceFromPickupFilter = new DistanceFromPickupFilter();

    walletBalanceFilter.setNext(distanceFromPickupFilter);

    walletBalanceFilter.run(filterContext);

    System.out.println("Filtered Vendors - ");
    filterContext.getResponse().forEach(v -> System.out.print(v+" "));
  }

  private static FilterRequest buildFilterRequest() {
    ConcurrentHashMap<Integer, Double> walletBalanceMap = new ConcurrentHashMap<>();
    walletBalanceMap.put(1, 10000.0);
    walletBalanceMap.put(2, 500.0);
    walletBalanceMap.put(3, 15000.0);


    ConcurrentHashMap<Integer, Double> distanceFromPickupMap = new ConcurrentHashMap<>();
    distanceFromPickupMap.put(1, 500.0);
    distanceFromPickupMap.put(2, 100.0);
    distanceFromPickupMap.put(3, 13000.0);

    return new FilterRequest(walletBalanceMap, distanceFromPickupMap);
  }
}
