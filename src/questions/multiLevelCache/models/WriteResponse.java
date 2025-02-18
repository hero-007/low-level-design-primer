package questions.multiLevelCache.models;

public class WriteResponse {
    private Integer writeTimeMillis;

    public WriteResponse(Integer writeTimeMillis) {
        this.writeTimeMillis = writeTimeMillis;
    }

    public Integer getWriteTimeMillis() {
        return writeTimeMillis;
    }

    public void setWriteTimeMillis(Integer writeTimeMillis) {
        this.writeTimeMillis = writeTimeMillis;
    }
}
