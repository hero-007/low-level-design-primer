package designPatterns.chainOfResponsibility;

public class BaseFilter implements Filter{
    private Filter nextFilter;

    @Override
    public void setNext(Filter filter) {
        nextFilter = filter;
    }

    @Override
    public void run(FilterContext context) {
        if (nextFilter != null)
            nextFilter.run(context);
    }
}
