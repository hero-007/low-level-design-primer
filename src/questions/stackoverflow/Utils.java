package questions.stackoverflow;

public class Utils {

    private static int counter = 87;

    public static int generateId() {
        counter++;
        return counter;
    }
}
