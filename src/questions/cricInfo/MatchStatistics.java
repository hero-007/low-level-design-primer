package questions.cricInfo;

public class MatchStatistics {
  private Team winningTeam;
  private Integer firstTeamRuns;
  private Integer secondTeamRuns;
  private Integer firstTeamWickets;
  private Integer secondTeamWickets;

  public MatchStatistics() {
  }

  public Team getWinningTeam() {
    return winningTeam;
  }

  public void setWinningTeam(Team winningTeam) {
    this.winningTeam = winningTeam;
  }

  public Integer getFirstTeamRuns() {
    return firstTeamRuns;
  }

  public void setFirstTeamRuns(Integer firstTeamRuns) {
    this.firstTeamRuns = firstTeamRuns;
  }

  public Integer getSecondTeamRuns() {
    return secondTeamRuns;
  }

  public void setSecondTeamRuns(Integer secondTeamRuns) {
    this.secondTeamRuns = secondTeamRuns;
  }

  public Integer getFirstTeamWickets() {
    return firstTeamWickets;
  }

  public void setFirstTeamWickets(Integer firstTeamWickets) {
    this.firstTeamWickets = firstTeamWickets;
  }

  public Integer getSecondTeamWickets() {
    return secondTeamWickets;
  }

  public void setSecondTeamWickets(Integer secondTeamWickets) {
    this.secondTeamWickets = secondTeamWickets;
  }

  @Override
  public String toString() {
    return "MatchStatistics{" +
      "winningTeam=" + winningTeam +
      ", firstTeamRuns=" + firstTeamRuns +
      ", secondTeamRuns=" + secondTeamRuns +
      ", firstTeamWickets=" + firstTeamWickets +
      ", secondTeamWickets=" + secondTeamWickets +
      '}';
  }
}
