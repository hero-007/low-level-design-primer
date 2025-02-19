package questions.pendencySystem.strategies;

import questions.pendencySystem.IPendencySystemStrategy;
import questions.pendencySystem.exceptions.IdentifierAlreadyExist;
import questions.pendencySystem.exceptions.IdentifierDoesNotExist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultPendencySystemStrategy<Identifier, Tag> implements IPendencySystemStrategy<Identifier, Tag> {

  private class DefaultPendencySystemNode {
    Map<Tag, DefaultPendencySystemNode> children;
    long countTags;
    boolean endOfHierarchy;

    public DefaultPendencySystemNode() {
      children = new HashMap<>();
      endOfHierarchy = false;
      countTags = 0;
    }
  }


  private DefaultPendencySystemNode root;
  private HashMap<Identifier, List<Tag>> identifierToTagsMap;

  public DefaultPendencySystemStrategy() {
    root = new DefaultPendencySystemNode();
    identifierToTagsMap = new HashMap<>();
  }

  @Override
  public void startTracking(Identifier identifier, List<Tag> tags) throws IdentifierAlreadyExist {
    if (identifierToTagsMap.containsKey(identifier))
      throw new IdentifierAlreadyExist(identifier.toString());

    identifierToTagsMap.put(identifier, tags);
    insertRecursively(root, identifier, tags, 0);
  }

  private void insertRecursively(DefaultPendencySystemNode current, Identifier identifier, List<Tag> tags, int index) {
    if (index == tags.size()) {
      current.endOfHierarchy = true;
      return;
    }

    Tag tag = tags.get(index);
    DefaultPendencySystemNode node = current.children.get(tag);

    if (node == null) {
      node = new DefaultPendencySystemNode();
    }

    node.countTags += 1;
    current.children.put(tag, node);

    insertRecursively(node, identifier, tags, index+1);
  }

  @Override
  public void stopTracking(Identifier identifier) throws IdentifierDoesNotExist {
    if (!identifierToTagsMap.containsKey(identifier))
      throw new IdentifierDoesNotExist(identifier.toString());

    List<Tag> tags = identifierToTagsMap.get(identifier);
    deleteRecursively(root, identifier, tags, 0);
    identifierToTagsMap.remove(identifier);
  }

  private boolean deleteRecursively(DefaultPendencySystemNode current, Identifier identifier, List<Tag> tags, Integer index) {
    if (index == tags.size()) {
      if (!current.endOfHierarchy) {
        return false;
      }

      current.endOfHierarchy = false;
      return current.children.size() == 0;
    }

    Tag tag = tags.get(index);
    DefaultPendencySystemNode node = current.children.get(tag);

    if (node == null)
      return false;

    current.countTags -= 1;
    boolean shouldDeleteCurrentNode = deleteRecursively(node, identifier, tags, index+1);

    if (shouldDeleteCurrentNode) {
      current.children.remove(tag);
      return current.children.size() == 0;
    }

    return false;
  }

  @Override
  public Long getCount(List<Tag> tags) {
    return searchRecursively(root, tags, 0);
  }

  private Long searchRecursively(DefaultPendencySystemNode current, List<Tag> tags, Integer index) {
    if (index == tags.size()) {
      return current.countTags;
    }

    Tag tag = tags.get(index);
    DefaultPendencySystemNode node = current.children.get(tag);

    if (node == null) return 0L;
    return searchRecursively(node, tags, index+1);
  }
}
