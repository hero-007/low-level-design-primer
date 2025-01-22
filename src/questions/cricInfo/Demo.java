package questions.cricInfo;

import java.time.Duration;
import java.time.Instant;

public class Demo {

  public static void main(String[] args) {
    CricketInfoSystem cricketInfoSystem = new CricketInfoSystem();
    Player playerOne = new Player(1L, "Akhil", 26);
    Player playerTwo = new Player(2L, "Shanu", 20);
    Player playerThree = new Player(3L, "Akshat", 28);
    Player playerFour = new Player(4L, "Ankur", 27);

    Team teamOne = new Team(1L, "Knight Riders");
    Team teamTwo = new Team(2L, "Royal Challengers");

    cricketInfoSystem.addTeam(teamOne);
    cricketInfoSystem.addTeam(teamTwo);

    cricketInfoSystem.addPlayer(playerOne, teamOne);
    cricketInfoSystem.addPlayer(playerTwo, teamOne);

    cricketInfoSystem.addPlayer(playerThree, teamTwo);
    cricketInfoSystem.addPlayer(playerFour, teamTwo);

    Match match = new Match(1L, "Team One vs Team Two", teamOne, teamTwo, Instant.now().plusSeconds(3600*24), Instant.now().plusSeconds(3600*30));

    cricketInfoSystem.addMatch(match);

    System.out.println(cricketInfoSystem.findPlayer("Akhil").getStatistics());
    cricketInfoSystem.getAllMatches(MatchStatus.SCHEDULED).forEach(selectedMatch -> System.out.println(selectedMatch));
  }
}
