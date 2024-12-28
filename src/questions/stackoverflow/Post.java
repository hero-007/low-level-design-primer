package questions.stackoverflow;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Post {
    private Integer id;
    private User postedBy;
    private List<Vote> votes;
    private List<Comment> comments;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;

    public Post() {
    }

    public Post(User postedBy, String content) {
        this.id = generateId();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.content = content;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.postedBy = postedBy;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedAt = Instant.now();
    }

    private Integer generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void votePost(Vote vote) {
        this.votes.add(vote);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Vote> getTotalVotes(VoteType type) {
        return votes.stream().filter(vote -> vote.getType() == type).collect(Collectors.toList());
    }

    public Integer getTotalVotesCount(VoteType type) {
        return getTotalVotes(type).size();
    }
}
