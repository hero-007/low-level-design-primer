package questions.stackoverflow;

public class Answer extends Post {
    private Question question;

    public Answer(User user, String content, Question question) {
        super(user, content);
        this.question = question;
    }
}
