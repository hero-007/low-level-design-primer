package questions.searchEngineForTechBlog.searchStrategy;

import questions.searchEngineForTechBlog.BlogCategory;
import questions.searchEngineForTechBlog.BlogPost;

import java.util.List;

public interface SearchStrategy {
  List<BlogPost> search(String query, BlogCategory category);
}
