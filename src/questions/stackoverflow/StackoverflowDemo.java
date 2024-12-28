package questions.stackoverflow;

import java.util.Arrays;
import java.util.List;

public class StackoverflowDemo {

    public static void main(String[] args) {
        StackoverFlow app = new StackoverFlow();

        User akhil = app.createUser("akhil.tiwari@theporter.in", "akhil.tiwari");
        User vaibhav = app.createUser("vaibhav.tiwari@gmail.com", "vaibhav.tiwari");
        User akshat = app.createUser("akshat.phondani@gmail.com", "akshat.phondani");

        List<String> tags = Arrays.asList("java", "stream api");
        Question q = app.askQuestion(akhil, "How to use stream in Java?", "Can you please explain how do I use java stream API in my project?", tags);

        Answer a1 = app.answerQuestion(vaibhav, q, "Java stream API is present in java utils pakage.");
        Answer a2 = app.answerQuestion(akshat, q, "What is a java stream, no idea.");

        app.postComment(akhil, "I need answer!", a2);
        app.downvotePost(akhil, a2);
        app.upvotePost(akhil, a1);


        List<Question> relatedQuestions = app.searchQuestions("java stream");
        relatedQuestions.forEach(question -> System.out.println(question.getTitle()));
    }
}
