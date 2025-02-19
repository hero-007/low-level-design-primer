package questions.pendencySystem;

import questions.pendencySystem.exceptions.IdentifierAlreadyExist;
import questions.pendencySystem.exceptions.IdentifierDoesNotExist;
import questions.pendencySystem.strategies.DefaultPendencySystemStrategy;

import java.util.List;

public class PendencySystem<Identifier, Tag> {
  private IPendencySystemStrategy pendencySystemStrategy;

  public PendencySystem(IPendencySystemStrategy pendencySystemStrategy) {
    this.pendencySystemStrategy = pendencySystemStrategy;
  }

  public PendencySystem() {
    this.pendencySystemStrategy = new DefaultPendencySystemStrategy();
  }

  public void startTracking(Identifier identifier, List<Tag> tags) throws IdentifierAlreadyExist {
    pendencySystemStrategy.startTracking(identifier, tags);
  }

  public void stopTracking(Identifier identifier) throws IdentifierDoesNotExist {
    pendencySystemStrategy.stopTracking(identifier);
  }

  public long getCount(List<Tag> tags) {
    return pendencySystemStrategy.getCount(tags);
  }

  public IPendencySystemStrategy getPendencySystemStrategy() {
    return pendencySystemStrategy;
  }

  public void setPendencySystemStrategy(IPendencySystemStrategy pendencySystemStrategy) {
    this.pendencySystemStrategy = pendencySystemStrategy;
  }
}
