package questions.stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackoverFlow {
    private Map<Integer, User> users;
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
    private Map<String, Tag> tagsMap;

    public StackoverFlow() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tagsMap = new ConcurrentHashMap<>();
    }

    public User createUser(String email, String username) {
        User user = new User(username, email);
        users.put(user.getId(), user);

        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        List<Tag> tagList = tags.stream().map(tag -> new Tag(tag)).collect(Collectors.toList());
        Question question = user.askQuestion(title, content, tagList);
        tagList.forEach(tag -> tagsMap.putIfAbsent(tag.getName(), tag));
        questions.putIfAbsent(question.getId(), question);

        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(content, question);
        answers.putIfAbsent(answer.getId(), answer);

        return answer;
    }

    public Comment postComment(User user, String content, Post post) {
        Comment comment = user.postComment(content, post);

        return comment;
    }

    public void upvotePost(User user, Post post) {
        user.upvotePost(post);
    }

    public void downvotePost(User user, Post post) {
        user.downvotePost(post);
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }
}
