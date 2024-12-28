package questions.searchEngineForTechBlog;

import questions.stackoverflow.Utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Author {
  private int id;
  private String name;
  private String email;
  private List<BlogPost> blogPosts;

  private Instant createdAt;
  private Instant updatedAt;

  public Author(String name, String email) {
    this.id = Utils.generateId();
    this.name = name;
    this.email = email;
    blogPosts = new ArrayList<>();
    createdAt = Instant.now();
    updatedAt = Instant.now();
  }

  public void addBlogPost(BlogPost post) {
    blogPosts.add(post);
  }

  public List<BlogPost> getBlogPosts() {
    return blogPosts;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "name=" + name;
  }
}
