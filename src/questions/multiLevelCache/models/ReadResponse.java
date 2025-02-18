package questions.multiLevelCache.models;

public class ReadResponse<Value> {
    private Value value;
    private Integer readTimeMillis;

    public ReadResponse(Value value, Integer readTimeMillis) {
        this.value = value;
        this.readTimeMillis = readTimeMillis;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Integer getReadTimeMillis() {
        return readTimeMillis;
    }

    public void setReadTimeMillis(Integer readTimeMillis) {
        this.readTimeMillis = readTimeMillis;
    }
}
