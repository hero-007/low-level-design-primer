package questions.loggingFramework;

public class ConsoleAppender implements LogAppender{
  @Override
  public void logMessage(LogMessage logMessage) {
    System.out.println(logMessage.toString());
  }
}
