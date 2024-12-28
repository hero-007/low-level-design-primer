package questions.searchEngineForTechBlog;

import questions.stackoverflow.Utils;

import java.time.Instant;

public class BlogPost {
  private Integer id;
  private String title;
  private String content;
  private Author author;
  private BlogCategory blogCategory;
  private Instant createdAt;
  private Instant updatedAt;

  public BlogPost(String title, String content, Author author, BlogCategory blogCategory) {
    this.id = Utils.generateId();
    this.title = title;
    this.content = content;
    this.author = author;
    this.blogCategory = blogCategory;
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public BlogCategory getBlogCategory() {
    return blogCategory;
  }

  public void setBlogCategory(BlogCategory blogCategory) {
    this.blogCategory = blogCategory;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  @Override
  public String toString() {
    return
      "title='" + title + '\'' +
      ", content='" + content + '\'' +
      ", author=" + author +
      ", blogCategory=" + blogCategory;
  }
}
