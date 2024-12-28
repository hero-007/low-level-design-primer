package questions.loggingFramework;

import java.time.Instant;

public class Logger {
  private static Logger logger;
  private static LoggerConfig loggerConfig;

  private Logger() {}

  public static Logger getInstance(LoggerConfig config) {
    if (logger == null) {
      logger = new Logger();
      loggerConfig = config;
    }

    return logger;
  }

  private void logMessage(LogLevel level, String message) {
    if (level.ordinal() >= loggerConfig.getLogLevel().ordinal()) {
      LogMessage logMessage = new LogMessage(Instant.now(), level, message);
      loggerConfig.getAppender().logMessage(logMessage);
    }
  }

  public void debug(String message) {
    logMessage(LogLevel.DEBUG, message);
  }

  public void info(String message) {
    logMessage(LogLevel.INFO, message);
  }

  public void warn(String message) {
    logMessage(LogLevel.WARN, message);
  }

  public void error(String message) {
    logMessage(LogLevel.ERROR, message);
  }

  public void fatal(String message) {
    logMessage(LogLevel.FATAL, message);
  }
}
