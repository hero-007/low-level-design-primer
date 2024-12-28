package questions.inMemoryRelationDatabase;

import java.util.List;

public interface TableManager {
  Table createTable(String name, List<Column> columns);
  void dropTable(String name);
}
