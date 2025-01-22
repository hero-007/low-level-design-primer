package questions.cricInfo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CricketInfoSystem {
  private List<Match> matches;
  private List<Team> teams;
  private List<Player> players;

  public CricketInfoSystem() {
    matches = new ArrayList<>();
    teams = new ArrayList<>();
    players = new ArrayList<>();
  }

  public Team findTeam(String name) {
    return teams.stream().filter(team -> team.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
  }

  public Player findPlayer(String name) {
    return players.stream().filter(player -> player.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
  }

  public Match findMatch(String name) {
    return matches.stream().filter(match -> match.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
  }

  public void addMatch(Match match) {
    matches.add(match);
  }

  public void removeMatch(Match match) {
    matches.remove(match);
  }

  public void addTeam(Team team) {
    teams.add(team);
  }

  public void removeTeam(Team team) {
    teams.remove(team);
  }

  public void addPlayer(Player player, Team team) {
    players.add(player);
    team.addPlayer(player);
    player.setTeam(team);
  }

  public void removePlayer(Player player) {
    players.remove(player);
    Team team = player.getTeam();
    team.removePlayer(player);
    player.setTeam(null);
  }

  public List<Match> getAllMatches(MatchStatus matchStatus) {
    return matches.stream().filter(match -> match.getMatchStatus() == matchStatus).collect(Collectors.toList());
  }

}
