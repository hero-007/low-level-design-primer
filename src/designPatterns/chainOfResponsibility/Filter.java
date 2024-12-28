package designPatterns.chainOfResponsibility;

public interface Filter {
    void setNext(Filter filter);
    void run(FilterContext context);
}
