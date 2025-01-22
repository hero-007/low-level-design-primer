package questions.cricInfo;

import java.util.ArrayList;
import java.util.List;

public class Team {
  private Long id;
  private String name;

  private Player captain;
  private Player viceCaptain;

  private List<Player> players;
  private TeamStatistics teamStatistics;

  public Team(Long id, String name) {
    this.id = id;
    this.name = name;
    players = new ArrayList<>();
    this.teamStatistics = new TeamStatistics();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Player getCaptain() {
    return captain;
  }

  public void setCaptain(Player captain) {
    this.captain = captain;
  }

  public Player getViceCaptain() {
    return viceCaptain;
  }

  public void setViceCaptain(Player viceCaptain) {
    this.viceCaptain = viceCaptain;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public void addPlayer(Player player) {
    if (players.contains(player)) return;
    players.add(player);
  }

  public void removePlayer(Player player) {
    players.remove(player);
  }

  public TeamStatistics getTeamStatistics() {
    return teamStatistics;
  }

  public void setTeamStatistics(TeamStatistics teamStatistics) {
    this.teamStatistics = teamStatistics;
  }
}
