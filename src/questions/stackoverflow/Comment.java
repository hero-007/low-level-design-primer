package questions.stackoverflow;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comment {
    private Integer id;
    private String content;
    private User user;
    private List<Vote> votes;
    private Instant createdAt;
    private Instant updatedAt;

    public Comment() {
    }

    public Comment(String content, User user) {
        this.id = generateId();
        this.content = content;
        this.user = user;
        this.votes = new ArrayList<>();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedAt = Instant.now();
    }

    public User getUser() {
        return user;
    }

    public void upVotePost(User user) {
        this.votes.add(new Vote(user, VoteType.Upvote));
    }

    public void downVotePost(User user) {
        this.votes.add(new Vote(user, VoteType.Downvote));
    }

    private Integer generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
