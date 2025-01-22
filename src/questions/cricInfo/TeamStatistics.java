package questions.cricInfo;

public class TeamStatistics {
  private int wins;
  private int draws;
  private int losses;

  public TeamStatistics() {
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getDraws() {
    return draws;
  }

  public void setDraws(int draws) {
    this.draws = draws;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }

  @Override
  public String toString() {
    return "TeamStatistics{" +
      "wins=" + wins +
      ", draws=" + draws +
      ", losses=" + losses +
      '}';
  }
}
