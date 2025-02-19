package questions.pendencySystem;

import java.util.List;

public interface IPendencySystemStrategy<Identifier, Tag> {
  void startTracking(Identifier identifier, List<Tag> tags);
  void stopTracking(Identifier identifier);
  Long getCount(List<Tag> tags);
}
