package designPatterns.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterContext {
    private FilterRequest request;
    private List<FilterResponse> filterResponses;
    private List<Integer> response;

    public FilterContext(FilterRequest request, List<Integer> inputVendors) {
        this.response = inputVendors;
        this.request = request;
        this.filterResponses = new ArrayList<>();
    }

    public void addFilterResponse(FilterResponse response) {
        filterResponses.add(response);
    }

    public List<Integer> getResponse() {
        return response;
    }

    public void setResponse(List<Integer> response) {
        this.response = response;
    }

    public FilterRequest getRequest() {
        return request;
    }
}
