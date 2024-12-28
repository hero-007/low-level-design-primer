package questions.searchEngineForTechBlog.searchStrategy;

import questions.searchEngineForTechBlog.BlogCategory;
import questions.searchEngineForTechBlog.BlogPost;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnorderedSearchStrategy implements SearchStrategy {

  @Override
  public List<BlogPost> search(String query, BlogCategory category) {
    Set<BlogPost> postSet = new HashSet<>();
    String[] queryWords = query.toLowerCase().split(" ");

    for(String queryWord: queryWords) {
      Set<BlogPost> matchingBlogPosts = category.getMatchingBlogPosts(queryWord);
      if (matchingBlogPosts!= null && !matchingBlogPosts.isEmpty())
        postSet.addAll(matchingBlogPosts);
    }

    return new ArrayList<>(postSet);
  }

}
