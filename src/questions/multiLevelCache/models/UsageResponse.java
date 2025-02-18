package questions.multiLevelCache.models;

public class UsageResponse {
    private Float usagePercentage;

    public UsageResponse(Float usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    public Float getUsagePercentage() {
        return usagePercentage;
    }

    public void setUsagePercentage(Float usagePercentage) {
        this.usagePercentage = usagePercentage;
    }
}
