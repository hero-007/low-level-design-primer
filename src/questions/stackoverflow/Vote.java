package questions.stackoverflow;

public class Vote {
    private Integer id;
    private User user;
    private VoteType type;

    public Vote(User user, VoteType type) {
        this.id = generateId();
        this.user = user;
        this.type = type;
    }

    public Vote() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VoteType getType() {
        return type;
    }

    public void setType(VoteType type) {
        this.type = type;
    }

    private Integer generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
