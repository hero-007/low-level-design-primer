package questions.loggingFramework;

public class Client {

  public static void main(String[] args) {
    LogAppender appender = new ConsoleAppender();

    LoggerConfig config = new LoggerConfig(LogLevel.INFO, appender);

    Logger logger = Logger.getInstance(config);
    logger.info("log a info message");
    logger.debug("log a debug message");
    logger.error("log a error message");
  }
}
