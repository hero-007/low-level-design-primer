package questions.cricInfo;

import java.time.Instant;

public class Match {
  private Long id;
  private String name;

  private Team firstTeam;
  private Team secondTeam;

  private Instant startTs;
  private Instant endTs;

  private MatchStatus matchStatus;
  private MatchStatistics matchStatistics;

  public Match(Long id, String name, Team firstTeam, Team secondTeam, Instant startTs, Instant endTs) {
    this.id = id;
    this.name = name;
    this.firstTeam = firstTeam;
    this.secondTeam = secondTeam;
    this.startTs = startTs;
    this.endTs = endTs;
    this.matchStatus = MatchStatus.SCHEDULED;
    this.matchStatistics = new MatchStatistics();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Team getFirstTeam() {
    return firstTeam;
  }

  public void setFirstTeam(Team firstTeam) {
    this.firstTeam = firstTeam;
  }

  public Team getSecondTeam() {
    return secondTeam;
  }

  public void setSecondTeam(Team secondTeam) {
    this.secondTeam = secondTeam;
  }

  public Instant getStartTs() {
    return startTs;
  }

  public void setStartTs(Instant startTs) {
    this.startTs = startTs;
  }

  public Instant getEndTs() {
    return endTs;
  }

  public void setEndTs(Instant endTs) {
    this.endTs = endTs;
  }

  public MatchStatus getMatchStatus() {
    return matchStatus;
  }

  public void setMatchStatus(MatchStatus matchStatus) {
    this.matchStatus = matchStatus;
  }

  public MatchStatistics getMatchStatistics() {
    return matchStatistics;
  }

  @Override
  public String toString() {
    return "Match{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", firstTeam=" + firstTeam +
      ", secondTeam=" + secondTeam +
      ", startTs=" + startTs +
      ", endTs=" + endTs +
      ", matchStatus=" + matchStatus +
      ", matchStatistics=" + matchStatistics +
      '}';
  }
}
