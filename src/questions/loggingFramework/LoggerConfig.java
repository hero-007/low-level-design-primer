package questions.loggingFramework;

import java.util.List;

public class LoggerConfig {
  private LogLevel logLevel;
  private LogAppender appender;


  public LoggerConfig(LogLevel logLevel, LogAppender appender) {
    this.logLevel = logLevel;
    this.appender = appender;
  }

  public LogLevel getLogLevel() {
    return logLevel;
  }

  public LogAppender getAppender() {
    return appender;
  }
}
