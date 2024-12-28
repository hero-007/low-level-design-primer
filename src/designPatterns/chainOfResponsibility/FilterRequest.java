package designPatterns.chainOfResponsibility;

import java.util.concurrent.ConcurrentHashMap;

public class FilterRequest {
    private ConcurrentHashMap<Integer, Double> vendorIdToWalletBalanceMap;
    private ConcurrentHashMap<Integer, Double> vendorIdToDistanceFromPickupMap;

    public FilterRequest(ConcurrentHashMap<Integer, Double> vendorIdToWalletBalanceMap, ConcurrentHashMap<Integer, Double> vendorIdToDistanceFromPickupMap) {
        this.vendorIdToDistanceFromPickupMap = vendorIdToDistanceFromPickupMap;
        this.vendorIdToWalletBalanceMap = vendorIdToWalletBalanceMap;
    }

    public ConcurrentHashMap<Integer, Double> getVendorIdToWalletBalanceMap() {
        return vendorIdToWalletBalanceMap;
    }

    public ConcurrentHashMap<Integer, Double> getVendorIdToDistanceFromPickupMap() {
        return vendorIdToDistanceFromPickupMap;
    }

}
