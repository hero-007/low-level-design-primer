package questions.searchEngineForTechBlog;

import questions.stackoverflow.Utils;

import java.time.Instant;
import java.util.*;

public class BlogCategory {
  private int id;
  private String category;
  private List<BlogPost> blogPosts;

  private Map<String, Set<BlogPost>> invertedIndex;
  private Instant createdAt;
  private Instant updatedAt;


  public BlogCategory(String category) {
    this.id = Utils.generateId();
    this.category = category;
    this.blogPosts = new ArrayList<>();
    this.invertedIndex = new HashMap<>();
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  public void addBlogPost(BlogPost post) {
    blogPosts.add(post);
    updateInvertedIndex(post);
  }

  public List<BlogPost> getBlogPosts() {
    return blogPosts;
  }

  public Set<BlogPost> getMatchingBlogPosts(String word) {
    return invertedIndex.get(word);
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return
      "category=" + category;
  }

  private void updateInvertedIndex(BlogPost post) {
    // Index is created on the title of the post
    String[] words = post.getTitle().toLowerCase().trim().split(" ");
    for (String word: words) {
      Set<BlogPost> mappedPosts = invertedIndex.get(word);
      if (mappedPosts == null) {
        Set<BlogPost> postSet = new HashSet<>();
        postSet.add(post);
        invertedIndex.put(word, postSet);
      } else {
        mappedPosts.add(post);
      }
    }
  }

}