package questions.searchEngineForTechBlog.orderingStrategy;

import questions.searchEngineForTechBlog.BlogPost;

import java.util.List;

public interface OrderingStrategy {
  List<BlogPost> order(List<BlogPost> blogPosts, SortingOrder sortingOrder);
}
