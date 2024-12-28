package questions.searchEngineForTechBlog.searchStrategy;

public class SearchStrategyFactory {

  public static SearchStrategy createSearchStrategy(SearchType searchType) {
    if (searchType == SearchType.UNORDERED)
      return new UnorderedSearchStrategy();
    else if (searchType == SearchType.ORDERED)
      return new OrderSearchStrategy();
    else if (searchType == SearchType.EXACT_MATCH)
      return new ExactMatchSearchStrategy();
    else throw new IllegalStateException("Unknown search type "+searchType.name());
  }
}
