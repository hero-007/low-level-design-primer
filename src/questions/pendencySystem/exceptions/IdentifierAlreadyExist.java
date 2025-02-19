package questions.pendencySystem.exceptions;

public class IdentifierAlreadyExist extends IllegalArgumentException {
  public IdentifierAlreadyExist(String identifier) {
    super(""+identifier+" already exist in the pendency system.");
  }
}
