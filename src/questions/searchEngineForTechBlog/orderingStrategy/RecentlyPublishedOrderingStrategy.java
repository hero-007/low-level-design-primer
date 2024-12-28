package questions.searchEngineForTechBlog.orderingStrategy;

import questions.searchEngineForTechBlog.BlogPost;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecentlyPublishedOrderingStrategy implements OrderingStrategy{
  @Override
  public List<BlogPost> order(List<BlogPost> blogPosts, SortingOrder orderBy) {
    if (orderBy == SortingOrder.ASC)
      Collections.sort(blogPosts, Comparator.comparing(BlogPost::getCreatedAt));
    else
      Collections.sort(blogPosts, Comparator.comparing(BlogPost::getCreatedAt, Comparator.reverseOrder()));

    return blogPosts;
  }
}
