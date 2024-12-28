package questions.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private String email;

    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private Integer reputation;

    private static final int ANSWER_REPUTATION = 5;
    private static final int QUESTION_REPUTATION = 3;
    private static final int COMMENT_REPUTATION = 1;

    public User(String username, String email) {
        this.id = Utils.generateId();
        this.username = username;
        this.email = email;

        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();

        reputation = 0;
    }

    public Question askQuestion(String title, String content, List<Tag> tags) {
        Question question = new Question(title, content, this);
        tags.forEach(tag -> question.addTag(tag));
        questions.add(question);

        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(String content, Question question) {
        Answer answer = new Answer(this, content, question);
        question.postAnswer(answer);
        answers.add(answer);

        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment postComment(String content, Post post) {
        Comment comment = new Comment(content, this);
        post.addComment(comment);
        comments.add(comment);

        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public void upvotePost(Post post) {
        Vote vote = new Vote(this, VoteType.Upvote);
        post.votePost(vote);
    }

    public void downvotePost(Post post) {
        Vote vote = new Vote(this, VoteType.Downvote);
        post.votePost(vote);
    }


    private void updateReputation(int value) {
        reputation += value;
    }

    public Integer getId() {
        return id;
    }

//    private Integer generateId() {
//        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
//    }
}
