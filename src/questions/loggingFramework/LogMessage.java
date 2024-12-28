package questions.loggingFramework;

import java.time.Instant;

public class LogMessage {
  private Instant ts;
  private LogLevel level;
  private String message;

  public LogMessage(Instant ts, LogLevel level, String message) {
    this.ts = ts;
    this.level = level;
    this.message = message;
  }

  @Override
  public String toString() {
    return
      "ts=" + ts +
      ", level=" + level +
      ", message=" + message;
  }
}
