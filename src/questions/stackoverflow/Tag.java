package questions.stackoverflow;

public class Tag {
    private Integer id;
    private String name;

    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private Integer generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
