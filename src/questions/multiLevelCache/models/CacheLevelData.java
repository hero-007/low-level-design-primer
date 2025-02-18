package questions.multiLevelCache.models;

public class CacheLevelData {
    private Integer readTimeMillis;
    private Integer writeTimeMillis;

    public CacheLevelData(Integer readTimeMillis, Integer writeTimeMillis) {
        this.readTimeMillis = readTimeMillis;
        this.writeTimeMillis = writeTimeMillis;
    }

    public Integer getReadTimeMillis() {
        return readTimeMillis;
    }

    public void setReadTimeMillis(Integer readTimeMillis) {
        this.readTimeMillis = readTimeMillis;
    }

    public Integer getWriteTimeMillis() {
        return writeTimeMillis;
    }

    public void setWriteTimeMillis(Integer writeTimeMillis) {
        this.writeTimeMillis = writeTimeMillis;
    }
}
