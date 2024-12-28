package questions.searchEngineForTechBlog.orderingStrategy;

public class OrderingStrategyFactory {

  public static OrderingStrategy createOrderingStrategy(OrderingType orderingType) {
    if (orderingType == OrderingType.MOST_SEARCHED)
      return new MostSearchedOrderingStrategy();
    else if (orderingType == OrderingType.RECENTLY_UPDATED)
      return new RecentlyUpdatedOrderingStrategy();
    else if (orderingType == OrderingType.RECENTLY_PUBLISHED)
      return new RecentlyPublishedOrderingStrategy();
    else if (orderingType == OrderingType.AUTHOR_NAME)
      return new AuthorNameOrderingStrategy();
    else throw new IllegalStateException("Unknown ordering strategy"+orderingType.name());
  }

}
