package designPatterns.chainOfResponsibility;

import java.util.List;

public class FilterResponse {
    private String filterName;
    private List<Integer> inputVendors;
    private List<Integer> filteredVendors;
    private List<Integer> outputVendors;


    public FilterResponse(String filterName, List<Integer> inputVendors, List<Integer> filteredVendors, List<Integer> outputVendors) {
        this.filterName = filterName;
        this.inputVendors = inputVendors;
        this.filteredVendors = filteredVendors;
        this.outputVendors = outputVendors;
    }
}
