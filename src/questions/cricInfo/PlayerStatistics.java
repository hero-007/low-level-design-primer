package questions.cricInfo;

public class PlayerStatistics {
  private Integer matchesPlayed;
  private Float avgRunRate;
  private Float avgStrikeRate;

  public PlayerStatistics() {
  }

  public Integer getMatchesPlayed() {
    return matchesPlayed;
  }

  public void setMatchesPlayed(Integer matchesPlayed) {
    this.matchesPlayed = matchesPlayed;
  }

  public Float getAvgRunRate() {
    return avgRunRate;
  }

  public void setAvgRunRate(Float avgRunRate) {
    this.avgRunRate = avgRunRate;
  }

  public Float getAvgStrikeRate() {
    return avgStrikeRate;
  }

  public void setAvgStrikeRate(Float avgStrikeRate) {
    this.avgStrikeRate = avgStrikeRate;
  }

  @Override
  public String toString() {
    return "PlayerStatistics{" +
      "matchesPlayed=" + matchesPlayed +
      ", avgRunRate=" + avgRunRate +
      ", avgStrikeRate=" + avgStrikeRate +
      '}';
  }
}
