package questions.pendencySystem.exceptions;

public class IdentifierDoesNotExist extends IllegalArgumentException {
  public IdentifierDoesNotExist(String identifier) {
    super(""+identifier+" does not exist in the pendency system.");
  }
}
