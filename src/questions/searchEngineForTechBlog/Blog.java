package questions.searchEngineForTechBlog;

import questions.searchEngineForTechBlog.orderingStrategy.OrderingStrategy;
import questions.searchEngineForTechBlog.orderingStrategy.OrderingStrategyFactory;
import questions.searchEngineForTechBlog.orderingStrategy.OrderingType;
import questions.searchEngineForTechBlog.orderingStrategy.SortingOrder;
import questions.searchEngineForTechBlog.searchStrategy.SearchStrategy;
import questions.searchEngineForTechBlog.searchStrategy.SearchStrategyFactory;
import questions.searchEngineForTechBlog.searchStrategy.SearchType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blog {
  private static Blog blog;

  private List<BlogPost> blogPosts;
  private Map<String, BlogCategory> blogCategoriesMap;
  private Map<String, Author> authorsMap;
  private SearchStrategy searchStrategy;
  private OrderingStrategy orderingStrategy;

  private Blog(SearchType searchType, OrderingType orderingType) {
    blogCategoriesMap = new HashMap<>();
    blogPosts = new ArrayList<>();
    authorsMap = new HashMap<>();

    searchStrategy = SearchStrategyFactory.createSearchStrategy(searchType);
    orderingStrategy = OrderingStrategyFactory.createOrderingStrategy(orderingType);
  }

  public static Blog getInstance(SearchType searchType, OrderingType orderingType) {
    if (blog == null)
      blog = new Blog(searchType, orderingType);

    return blog;
  }

  public BlogPost createBlogPost(String title, String content, Author author, BlogCategory category) {
    BlogPost post = new BlogPost(title, content, author, category);
    category.addBlogPost(post);
    author.addBlogPost(post);

    blogPosts.add(post);

    return post;
  }

  public BlogCategory createBlogCategory(String name) {
    if (blogCategoriesMap.containsKey(name))
      throw new IllegalStateException("Category "+name+" already exists.");

    BlogCategory category = new BlogCategory(name);
    blogCategoriesMap.put(name, category);

    return category;
  }

  public Author createNewAuthor(String name, String email) {
    if (authorsMap.containsKey(email))
      throw new IllegalStateException("Email "+email+" already exists.");

    Author author = new Author(name, email);
    authorsMap.put(email, author);

    return author;
  }

  public List<BlogPost> searchBlogPosts(String query, BlogCategory category, SortingOrder sortingOrder) {
    List<BlogPost> searchResult = searchStrategy.search(query, category);
    List<BlogPost> orderedResult = orderingStrategy.order(searchResult, sortingOrder);

    return orderedResult;
  }
}
