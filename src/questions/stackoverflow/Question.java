package questions.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post {
    private String title;
    private List<Tag> tags;
    private List<Answer> answers;

    public Question(String title, String content, User user) {
        super(user, content);
        this.title = title;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public Question() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void postAnswer(Answer answer) {
        this.answers.add(answer);
    }

}
