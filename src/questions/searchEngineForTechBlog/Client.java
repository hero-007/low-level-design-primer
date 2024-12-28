package questions.searchEngineForTechBlog;

import questions.searchEngineForTechBlog.orderingStrategy.OrderingType;
import questions.searchEngineForTechBlog.orderingStrategy.SortingOrder;
import questions.searchEngineForTechBlog.searchStrategy.SearchType;

import java.util.List;

public class Client {

  public static void main(String[] args) {
    Blog techBlog = Blog.getInstance(SearchType.UNORDERED, OrderingType.RECENTLY_PUBLISHED);

    Author firstAuthor = techBlog.createNewAuthor("Akhil Tiwari", "akhil.tiwari@gmail.com");
    Author secondAuthor = techBlog.createNewAuthor("Vaibhav Tiwari", "vaibhav.tiwari@gmail.com");

    BlogCategory categoryAI = techBlog.createBlogCategory("AI");
    BlogCategory categoryBlockchain = techBlog.createBlogCategory("Blockchain");
    BlogCategory categoryGames = techBlog.createBlogCategory("Games");

    techBlog.createBlogPost("AI 2041", "Artificial Intelligence 2041", firstAuthor, categoryAI);
    techBlog.createBlogPost("AI 2051", "Artificial Intelligence 2051", secondAuthor, categoryAI);
    techBlog.createBlogPost("ML 2061", "Machine Learning 2061", firstAuthor, categoryAI);

    techBlog.createBlogPost("Blockchain 2041", "Blockchain 2041", firstAuthor, categoryBlockchain);
    techBlog.createBlogPost("Blockchain 2051", "Blockchain 2051", secondAuthor, categoryBlockchain);
    techBlog.createBlogPost("Blockchain 2061", "Blockchain 2061", firstAuthor, categoryBlockchain);

    techBlog.createBlogPost("Games 2041", "Games 2041", firstAuthor, categoryGames);
    techBlog.createBlogPost("Games 2051", "Games 2051", secondAuthor, categoryGames);
    techBlog.createBlogPost("Games 2061", "Games 2061", firstAuthor, categoryGames);

    List<BlogPost> firstSearchResults = techBlog.searchBlogPosts("AI", categoryAI, SortingOrder.ASC);
    firstSearchResults.forEach(result -> System.out.println(result));

    List<BlogPost> secondSearchResults = techBlog.searchBlogPosts("Games", categoryGames, SortingOrder.DESC);
    secondSearchResults.forEach(result -> System.out.println(result));
  }
}
