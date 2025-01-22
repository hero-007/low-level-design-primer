package questions.cricInfo;

public class Player {
  private Long id;
  private String name;
  private Integer age;
  private PlayerRole role;

  private PlayerStatistics statistics;
  private Team team;

  public Player(Long id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.statistics = new PlayerStatistics();
    this.team = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public PlayerRole getRole() {
    return role;
  }

  public void setRole(PlayerRole role) {
    this.role = role;
  }

  public PlayerStatistics getStatistics() {
    return statistics;
  }

  public void setStatistics(PlayerStatistics statistics) {
    this.statistics = statistics;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }
}
